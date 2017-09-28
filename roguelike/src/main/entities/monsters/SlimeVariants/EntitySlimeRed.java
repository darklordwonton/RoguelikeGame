package main.entities.monsters.SlimeVariants;

import main.entities.Stats;
import main.rendering.animation.Animation;
import main.util.Globals;

public class EntitySlimeRed extends EntitySlime {
	
	
	public EntitySlimeRed(int px, int py) {
		super(px, py);
		this.xpValue = 5;
		
		setSprite("enemy_slimes.png", (int)(Math.random() * 3), 1, 3);
		
		Animation.animate(this);
	}
	
}
