package main.entities.monsters.SlimeVariants;

import main.rendering.animation.Animation;

public class EntitySlimeGreen extends EntitySlime {
	
	
	public EntitySlimeGreen(int px, int py) {
		super(px, py);
		this.xpValue = 5;
		
		setSprite("enemy_slimes.png", (int)(Math.random() * 3), 0, 3);
		
		Animation.animate(this);
	}
	
}
