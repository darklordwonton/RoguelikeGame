package main.entities.monsters.SlimeVariants;

import main.rendering.animation.Animation;

public class EntitySlimeYellow extends EntitySlime {
	
	
	public EntitySlimeYellow(int px, int py) {
		super(px, py);
		this.xpValue = 5;
		
		setSprite("enemy_slimes.png", (int)(Math.random() * 3), 4, 3);
		
		Animation.animate(this);
	}
	
}
