import manager.PersistenceManager;
import models.City;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        String[] cityString = new String[]{"Ужгород", "Івано Франківськ", "Львів", "Луцьк", "Рівне",
                "Тернопіль", "Чернівці", "Хмельницький", "Житомир", "Вінниця", "Одеса", "Київ",
                "Черкаси", "Кіровоград", "Миколаїв", "Херсон", "Сімферопіль", "Чернігів", "Суми",
                "Полтава", "Дніпро", "Запоріжжя", "Харків", "Донецьк", "Луганськ"};

        City city;
        for (int i =0 ; i <cityString.length;i++) {
            city = new City();
            city.setCityName(cityString[i]);
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
        }
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
