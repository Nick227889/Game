package com.harmony.game.physics.collision;

import com.harmony.game.entity.Entity;
import com.harmony.game.graphics.Camera;
import com.harmony.game.tiles.ObjectTileMap;
import com.harmony.game.tiles.block.Block;
import com.harmony.game.utils.Vector2f;

public class BoxCollider {

    private Entity entity;
    private Vector2f offset;
    private ObjectTileMap tileMap;
    private int width;
    private int height;

    public BoxCollider(Entity entity, ObjectTileMap tileMap, Vector2f offset, int width, int height) {
        this.entity = entity;
        this.tileMap = tileMap;
        this.offset = offset;
        this.width = width;
        this.height = height;
    }

    public boolean collisionTile(float ax, float ay) {
        for(int c = 0; c < 4; c++) {

            int ex = (int) ((entity.position.x + ax + Camera.position.x) + (c % 2) * width + offset.x)  / 64;
            int ey = (int) ((entity.position.y + ay + Camera.position.y) + (c / 2) * height + offset.y) / 64;

            for(Block block : tileMap.getBlocks()) {
                if(block.getTilePosition().x == ex && block.getTilePosition().y == ey) return true;
            }
        }
        return false;
    }

    public Vector2f getOffset() {
        return offset;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
