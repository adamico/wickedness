package me.kc00l.wickedness.setup.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    public static ModConfigSpec SERVER_CONFIG;
    public static ModConfigSpec.IntValue INIT_MAX_WICKEDNESS;
    public static ModConfigSpec.IntValue INIT_WICKEDNESS_DECAY;
    public static ModConfigSpec.IntValue WICKEDNESS_DECAY_INTERVAL;
    public static ModConfigSpec.IntValue LOW_WICKEDNESS_VALUE;
    public static ModConfigSpec.IntValue MID_WICKEDNESS_VALUE;
    public static ModConfigSpec.IntValue HIGH_WICKEDNESS_VALUE;

    static {
        ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
        SERVER_BUILDER.comment("Wickedness decay").push("wickedness_decay");
        INIT_WICKEDNESS_DECAY = SERVER_BUILDER.comment("Base wickedness decay amount")
                .defineInRange("baseDecay", 1, 0, Integer.MAX_VALUE);
        INIT_MAX_WICKEDNESS = SERVER_BUILDER.comment("Base max wickedness")
                .defineInRange("baseMax", 100, 0, Integer.MAX_VALUE);
        WICKEDNESS_DECAY_INTERVAL = SERVER_BUILDER.comment("How often wickedness decays, in ticks")
                .defineInRange("decayInterval", 20, 1, 100);
        SERVER_BUILDER.comment("Wickedness amount from killing animals").push("wickedness_amounts");
        LOW_WICKEDNESS_VALUE = SERVER_BUILDER.comment("Wickedness amount for animals tagged with #wickedness:low_wickedness_entities")
                .defineInRange("low_wickedness", 10, 1, 20);
        MID_WICKEDNESS_VALUE = SERVER_BUILDER.comment("Wickedness amount for animals tagged with #wickedness:mid_wickedness_entities")
                .defineInRange("mid_wickedness", 50, 21, 60);
        HIGH_WICKEDNESS_VALUE = SERVER_BUILDER.comment("Wickedness amount for animals tagged with #wickedness:high_wickedness_entities")
                .defineInRange("high_wickedness", 80, 61, 100);
        SERVER_CONFIG = SERVER_BUILDER.build();
    }
}
