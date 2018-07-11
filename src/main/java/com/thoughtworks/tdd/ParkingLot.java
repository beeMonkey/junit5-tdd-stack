package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;
    private HashMap<Receipt,Car> parkcars;
    public ParkingLot(int capality) {
        this.size=capality;
        parkcars=new HashMap<>();
    }

    public boolean isFull() {
     return this.size-parkcars.size()==0;
    }

    public Receipt park(Car car) {
        if(isFull()){
            throw new ParkingLotFullException();
        }
        else {
            this.size--;
            Receipt receipt=new Receipt();
            this.parkcars.put(receipt,car);
            return receipt;
        }

    }

    public Car unPark(Receipt receipt) {
        this.size++;
       return parkcars.remove(receipt);
        //return this.parkcars.get(receipt);
    }
}
