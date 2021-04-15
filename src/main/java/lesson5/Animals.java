package lesson5;

public abstract class Animals {
    static final int swim_fail = 0; //усли не проплыло
    static final int swim_ok = 1; // проплыло
    static final int swim_none = -1; //плавать не умеет

    private String type;
    private String name;
    private float maxRun;
    private float maxJump;
    private float maxSwim;

    public Animals(String type, String name, float maxRun, float maxJump, float maxSwim) {
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.maxSwim = maxSwim;
    }
    String getName() {
        return this.name;
    }

    String getType() {
        return this.type;
    }

    float getMaxRun() {
        return this.maxRun;
    }

    float getMaxJump() {
        return this.maxJump;
    }

    float getMaxSwim() {
        return this.maxSwim;
    }
    protected boolean run (float distance){
        return (distance <= maxRun);
    }
    protected boolean jump (float height){
        return (height <= maxJump);
    }
    protected int swim (float distance){
        return (distance <= maxSwim) ? swim_ok : swim_fail;
    }
}
