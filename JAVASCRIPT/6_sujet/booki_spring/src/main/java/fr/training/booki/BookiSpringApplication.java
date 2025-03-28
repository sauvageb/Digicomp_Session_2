package fr.training.booki;

import fr.training.booki.entity.AccommodationEntity;
import fr.training.booki.entity.ActivityEntity;
import fr.training.booki.entity.CityEntity;
import fr.training.booki.repository.AccommodationRepository;
import fr.training.booki.repository.ActivityRepository;
import fr.training.booki.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class BookiSpringApplication implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final AccommodationRepository accommodationRepository;
    private final ActivityRepository activityRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookiSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ## Marseille
        CityEntity marseille = new CityEntity();
        marseille.setName("Marseille");
        marseille.setZipcode("13001");
        cityRepository.save(marseille);

        ActivityEntity[] activities = new ActivityEntity[]{
                createActivity("Vieux-port", "Visitez le Vieux-Port, le cœur historique de Marseille.", "Vieux-port.jpg", marseille),
                createActivity("Fort de Pomègues", "Explorez le fort historique de l'île de Pomègues.", "fort_pomegues.jpg", marseille),
                createActivity("Fort de Pomègues", "Autre activité à Fort de Pomègues, découvrez son histoire.", "fort_pomegues2.jpg", marseille),
                createActivity("Parc national des Calanques", "Randonnée et baignade dans les Calanques, un site naturel exceptionnel.", "calanques.jpg", marseille),
                createActivity("Parc national des Calanques", "Profitez des paysages incroyables du parc national des Calanques.", "calanques2.jpg", marseille),
                createActivity("Notre Dame de la Garde", "Visitez la basilique Notre-Dame-de-la-Garde pour une vue panoramique sur la ville.", "notre_dame.jpg", marseille),
                createActivity("Notre-Dame-de-la-Garde", "Découvrez l'histoire de la basilique Notre-Dame-de-la-Garde et son importance religieuse.", "notre_dame2.jpg", marseille)
        };

        activityRepository.saveAll(Arrays.asList(activities));

        AccommodationEntity[] accommodationEntities = new AccommodationEntity[]{
                createAccommodation("Hôtel du Vieux-Port", "Un hôtel avec vue imprenable sur le Vieux-Port.", "vieux_port_hotel.jpg", 120.00, 4, 2, marseille),
                createAccommodation("Auberge de Jeunesse", "Hébergement simple et économique au cœur de la ville.", "hostel_marseille.jpg", 30.00, 3, 6, marseille),
                createAccommodation("Hôtel du Port", "Nuit à partir de 52€", "hotel_du_port.jpg", 52.00, 4, 2, marseille),
                createAccommodation("Hôtel Chez Amina", "Nuit à partir de 96€", "hotel_chez_amina.jpg", 96.00, 4, 2, marseille),
                createAccommodation("Hôtel Les Mouettes", "Nuit à partir de 76€", "hotel_les_mouettes.jpg", 76.00, 4, 2, marseille),
                createAccommodation("Hôtel de la Mer", "Nuit à partir de 46€", "hotel_de_la_mer.jpg", 46.00, 4, 2, marseille),
                createAccommodation("Auberge La Canebière", "Nuit à partir de 25€", "auberge_la_canebiere.jpg", 25.00, 4, 6, marseille),
                createAccommodation("Auberge Le Panier", "Nuit à partir de 52€", "auberge_le_panier.jpg", 52.00, 4, 4, marseille),
                createAccommodation("Hôtel Le Soleil du Matin", "Nuit à partir de 128€", "hotel_soleil_du_matin.jpg", 128.00, 4, 2, marseille),
                createAccommodation("Chambres d’hôtes Au cœur de l’eau", "Nuit à partir de 71€", "chambres_au_coeur_de_leau.jpg", 71.00, 4, 2, marseille),
                createAccommodation("Hôtel Bleu et Blanc", "Nuit à partir de 68€", "hotel_bleu_et_blanc.jpg", 68.00, 4, 2, marseille)
        };

        accommodationRepository.saveAll(Arrays.asList(accommodationEntities));

        // ## Lausanne
        CityEntity lausanne = new CityEntity();
        lausanne.setName("Lausanne");
        lausanne.setZipcode("1000");
        cityRepository.save(lausanne);

        ActivityEntity[] activitiesLausanne = new ActivityEntity[]{
                createActivity("Visite du Musée Olympique", "Découvrez l'histoire des Jeux Olympiques et les exploits sportifs à Lausanne.", "olympic_museum.jpg", lausanne),
                createActivity("Croisière sur le Lac Léman", "Profitez d'une croisière panoramique sur le Lac Léman avec vue sur les Alpes.", "lake_cruise.jpg", lausanne),
                createActivity("Montée à la Cathédrale de Lausanne", "Visitez la Cathédrale de Lausanne et profitez de la vue imprenable depuis le cloître.", "cathedrale_lausanne.jpg", lausanne),
                createActivity("Parc de Mon Repos", "Promenez-vous dans ce parc paisible au cœur de Lausanne.", "parc_mon_repos.jpg", lausanne),
                createActivity("Château de Chillon", "Explorez le château médiéval situé sur les bords du Lac Léman.", "chateau_chillon.jpg", lausanne),
                createActivity("Le Flon", "Découvrez le quartier branché du Flon avec ses restaurants et boutiques.", "flon_lausanne.jpg", lausanne)
        };

        activityRepository.saveAll(Arrays.asList(activitiesLausanne));

        AccommodationEntity[] accommodationsLausanne = new AccommodationEntity[]{
                createAccommodation("Hôtel Beau-Rivage", "Luxe et confort avec vue magnifique sur le Lac Léman.", "beau_rivage.jpg", 300.00, 5, 2, lausanne),
                createAccommodation("Swiss Hostel Lausanne", "Auberge conviviale et moderne, idéale pour les voyageurs à petit budget.", "swiss_hostel.jpg", 45.00, 4, 8, lausanne)
        };

        accommodationRepository.saveAll(Arrays.asList(accommodationsLausanne));
    }

    private ActivityEntity createActivity(String name, String description, String pictureUrl, CityEntity cityEntity) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName(name);
        activityEntity.setDescription(description);
        activityEntity.setAddress(name + ", Marseille");
        activityEntity.setPrice(20.00);
        activityEntity.setPictureUrl(pictureUrl);
        activityEntity.setCity(cityEntity);
        return activityEntity;
    }

    private AccommodationEntity createAccommodation(String title, String description, String pictureUrl, double price, int rating, int capacity, CityEntity cityEntity) {
        AccommodationEntity accommodationEntity = new AccommodationEntity();
        accommodationEntity.setTitle(title);
        accommodationEntity.setDescription(description);
        accommodationEntity.setAddress(title);
        accommodationEntity.setPrice(price);
        accommodationEntity.setRating(rating);
        accommodationEntity.setCapacity(capacity);
        accommodationEntity.setPictureUrl(pictureUrl);
        accommodationEntity.setCity(cityEntity);
        return accommodationEntity;
    }
}
