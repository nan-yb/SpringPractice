package org.msa.item.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.msa.item.domain.Item;
import org.msa.item.dto.ItemDTO;
import org.msa.item.feign.HistoryFeignClient;
import org.msa.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
	private final ItemRepository itemRepository;
	private final HistoryFeignClient historyFeignClient;
	private final RestTemplate restTemplate;
	
	public void insertItem(ItemDTO itemDTO , String accountId) {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = form.format(new Date());
	
		Item item = Item.builder()
				.id(itemDTO.getId())
				.name(itemDTO.getName())
                .accountId(accountId)
				.description(itemDTO.getDescription())
				.itemType(itemDTO.getItemType())
				.count(itemDTO.getCount())
				.regDts(date)
				.updDts(date)
				.build();
		itemRepository.save(item);

		HashMap<String , Object> historyMap = new HashMap<>();
		historyMap.put("accountId" , accountId);
		historyMap.put("itemId" , itemDTO.getId());

//		FeignClient 이용
//		log.info("feign result = {}" , historyFeignClient.saveHistory(historyMap));

//		restTemplate 이용
		log.info("resttemplate result = {}" , restTemplate.postForObject("http://HISTORY_SERVICE/v1/history/save" , historyMap , String.class));
	}

}
