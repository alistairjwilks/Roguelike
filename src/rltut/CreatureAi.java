package rltut;

public abstract class CreatureAi {
    protected Creature creature;

    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setAi(this);
    }

    public abstract void onEnter(int x, int y, Tile tile);
}
