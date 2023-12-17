package org.msa.item.service;


import org.msa.item.domain.Item;
import org.msa.item.dto.ItemDTO;
import org.msa.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void insertItem(ItemDTO itemDTO) {
        SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = form.format(new Date());

        Item item = Item.builder()
                .id(itemDTO.getId())
                .name(itemDTO.getName())
                .description(itemDTO.getDescription())
                .count(itemDTO.getCount())
                .itemType(itemDTO.getItemType())
                .regDts(date)
                .updDts(date)
                .build();
        itemRepository.save(item);
    }
}
