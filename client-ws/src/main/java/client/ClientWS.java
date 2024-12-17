package client;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import javax.xml.transform.stream.StreamSource;
import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToMad(600));
        Compte cp = proxy.getCompte(4);
        System.out.println("-------------------");
        System.out.println(cp.getSolde());
        System.out.println(cp.getDateCreation());
        System.out.println(cp.getCode());
        List<Compte> compteList = proxy.listComptes();
        compteList.forEach(c->{
                System.out.println("------------");
                System.out.println(c.getSolde());
                System.out.println(c.getDateCreation());
                System.out.println(c.getCode());
                System.out.println("-----------------");
        });

    }
}
