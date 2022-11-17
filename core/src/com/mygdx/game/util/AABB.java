package com.mygdx.game.util;

import com.mygdx.game.Entity;

public class AABB {
    public static boolean isColliding(Entity entity1, Entity entity2) {
        return entity1.x < entity2.x + entity2.width && entity1.x + entity1.width > entity2.x && entity1.y < entity2.y + entity2.height && entity1.y + entity1.height > entity2.y;
    }
}
