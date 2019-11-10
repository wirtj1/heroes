public class EpicHeroService implements HeroService {
    int maxAtk = 20;
    int maxHP = 30;
    int maxDef = 22;

    public Hero createHero(String name) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setAtk((int)(Math.random()*maxAtk));
        hero.setDef((int)(Math.random()*maxDef));
        hero.setHp((int)(Math.random()*maxHP));
        return hero;
    }
}
