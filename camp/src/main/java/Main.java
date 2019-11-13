import config.ServiceConfiguration;
import entities.Hero;
import entities.Party;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PartyService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
		PartyService partyService = context.getBean(PartyService.class);
		Party party = partyService.createParty("Great party");
		for (Hero hero : party.getMembers()) {
			System.out.println(hero.getName() + " Def:" + hero.getDef() + " Atk:" + hero.getAtk() + " HP:" + hero.getHp());
		}
		context.close();
	}

}