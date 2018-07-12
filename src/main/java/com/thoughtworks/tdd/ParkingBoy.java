package com.thoughtworks.tdd;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public ParkingLot findFirstNotNullparkingLot(){
        ParkingLot firstNotNullparkingLot=null;
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull()){
                firstNotNullparkingLot=parkingLot;
            }
        }
        return firstNotNullparkingLot;

    }
    public Receipt park(Car car) {
        Receipt receipt = null;
        ParkingLot firstNotNullparkingLot=findFirstNotNullparkingLot();
        if(firstNotNullparkingLot!=null){
            receipt = findFirstNotNullparkingLot().park(car);
            return receipt;
        }
        else {
            throw new ParkingLotFullException();
        }

    }

//    public Receipt park(Car car) {
//        int wholesize = 0;
//        Receipt receipt = null;
//        for (ParkingLot parkingLot : parkingLots) {
//            wholesize = parkingLot.getSize();
//        }
//        if (wholesize != 0) {
//            ParkingLot firstNotNullparkingLot;
//            for (ParkingLot parkingLot : parkingLots) {
//                if (!parkingLot.isFull()) {
//                    firstNotNullparkingLot = parkingLot;
//                    receipt = firstNotNullparkingLot.park(car);
//                    break;
//                }
//            }
//            //return true;
//        } else {
//            throw new ParkingLotFullException();
//        }
//        return receipt;
//        //return false;
//    }

//    public Car unPark(Receipt receipt) {
//        if (this.parkingLots.get(0).getparkcars().remove(receipt) != null) {
////            Car getcar=null;
////            for (ParkingLot parkingLot : parkingLots) {
////                if(parkingLot.getparkcars().remove(receipt)!=null){
////                    getcar =parkingLot.getparkcars().remove(receipt);
////                }else{
////                    getcar=parkingLot.getparkcars().remove(receipt);
////                }
////
////            }
////            return getcar;
//            //通过小票把停车场的车取出来，一个停车场，一辆车
//            return this.parkingLots.get(0).getparkcars().remove(receipt);
//        } else {
//            return this.parkingLots.get(0).getparkcars().remove(receipt);
//        }
//
//    }

    public Car unPark(Receipt receipt) {
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            car = parkingLot.unPark(receipt);
            if(car==null)break;
        }
        return car;
    }


}
