package Ch12_Enum_Autobox_StaticImport_Annotations;

/**
 * Created by Ross on 22.10.2017.
 */
public enum Transport {
    CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);
    private int speed;

    Transport(int s) {
        speed = s;
    }

    int getSpeed() {
        return speed;
    }
}

class EnumDemo {
    public static void main(String[] args) {
        Transport tp1, tp2, tp3;
        tp1 = Transport.AIRPLANE;
        tp2 = Transport.TRAIN;
        tp3 = Transport.AIRPLANE;

        System.out.println("Типичная скорость самолета: " +
                Transport.AIRPLANE.getSpeed() +
                " миль/час\n");

        //Отобразить все виды транспорта и скорости их движения
        System.out.println("Типичные скорости движения транспортных средств");
        for (Transport t : Transport.values()) {
            System.out.println(t + ": " + t.getSpeed() + " миль в час");
        }

        //ordinal() возвращает порядковый номер константы в Enum счет идет с 0
        System.out.println(Transport.valueOf("AIRPLANE") + " " + tp1.ordinal());

        //Демонстрация использование метода compareTo()
        //Который сравнивает порядковые номера
        if (tp1.compareTo(tp2) < 0)
            System.out.println(tp1 + " идет перед " + tp2);
        if (tp1.compareTo(tp2) > 0)
            System.out.println(tp2 + " идет перед " + tp1);
        if (tp1.compareTo(tp3) == 0)
            System.out.println(tp1 + " совпадает с " + tp3);

    }
}
