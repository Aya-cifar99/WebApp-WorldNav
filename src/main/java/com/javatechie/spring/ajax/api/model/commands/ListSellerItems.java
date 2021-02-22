package com.javatechie.spring.ajax.api.model.commands;


import com.javatechie.spring.ajax.api.model.maze.GameMap;
import com.javatechie.spring.ajax.api.dto.Player;
import com.javatechie.spring.ajax.api.model.objects.Room;
import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.RoomObjects;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.Seller;

import java.util.ArrayList;

public class ListSellerItems implements Command {
    private Seller seller ;
    public ListSellerItems(GameMap mazeMap , Player player , String itemName){
        Room CurrRoom =   mazeMap.getRoom(player.getCurrRoomID());
        RoomObjects roomObject = player.getObjDir(CurrRoom) ;
        seller = ((Seller) roomObject);

    }

    @Override
    public String execute() {

        ArrayList<Items> sellerItems =  seller.listItems();
        String s = "";
        for (Items sellerItem : sellerItems) {
            s += sellerItem.toString();
        }
        return s ;
    }
}
