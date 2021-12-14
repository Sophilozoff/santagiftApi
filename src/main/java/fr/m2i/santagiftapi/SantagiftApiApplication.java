package fr.m2i.santagiftapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SantagiftApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SantagiftApiApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner run(GiftServiceImpl giftService){
//        return args -> {
//
//            giftService.save(new Gift("Statue Gorille", "https://www.maisonsdumonde.com/FR/fr/p/statue-gorille-et-bebe-noire-h105-family-210791.htm?cq_src=google_ads&cq_cmp=1784001525&cq_con=67551520965&cq_term=&cq_med=&cq_plac=&cq_net=u&cq_pos=&cq_plt=gp&gclid=Cj0KCQiAnuGNBhCPARIsACbnLzrxUySfP-A-1ElEhPMSciT1KkUZt0q1h0n4r31mgU4-92KlhZ9lYbcaAiPnEALw_wcB"));
//            giftService.save(new Gift("Canapé ", "https://www.selency.fr/produit/PX73PQ7Q/bombom.html?gclid=Cj0KCQiAnuGNBhCPARIsACbnLzqbBMjqMlSB3WE6YFKaMOvt6qz1F_Ra9nd9_9jX9PE4Z1eOceePCBcaApByEALw_wcB"));
//            giftService.save(new Gift("Chaise ", "https://www.laredoute.fr/ppdp/prod-530783825.aspx?dim1=1002&dim2=1000&docid=00000000000001&cod=PSN00094581FR&gclsrc=aw.ds&kard=1&kClkId=211214111344508548&kVsId=211214111344508889&gclid=Cj0KCQiAnuGNBhCPARIsACbnLzq0KTmkA60qgCdvNlveJfOOTaMTkEX1zwM5kOE0A2gdibjIhSPcHBIaAi9SEALw_wcB"));
//        };
//    }

}
