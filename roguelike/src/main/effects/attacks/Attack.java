package main.effects.attacks;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import main.effects.Effect;
import main.entities.Entity;
import main.filemanager.ImageManager;
import main.tiles.Tile;

public class Attack extends Effect {
	protected int lowDamage = 0; //Low bound of damage
	protected int highDamage = 0; //Upper bound of damage
	protected int bellCurve = 0;  //Randomization of damage. 1 is equal chance of anything, the higher the more likely it is to center
	
	protected int buf = 0; //Bonus to damage. Comes from buf and weapon enhancements (when we program them)
	
	protected Set<EnumAttackType> types = null; //Types of damage
	
	public Attack(int dl, int du, int bc, EnumAttackType t, Entity e) {
		super(e);
		lowDamage = dl;
		highDamage = du;
		bellCurve = bc;
		types = null;
		types.add(t);
		animationFrames = 32;
	}
	
	public Attack(int dl, int du, int bc, Set<EnumAttackType> t, Entity e) {
		super(e);
		lowDamage = dl;
		highDamage = du;
		bellCurve = bc;
		types = t;
		if (types == null) {
			types = new HashSet<EnumAttackType>();
		}
		animationFrames = 32;
	}
	
	public boolean isType (EnumAttackType t) {
		return types.contains(t);
	}
	
	public void addType (EnumAttackType t) {
		types.add(t);
	}
	
	public void removeType (EnumAttackType t) {
		types.remove(t);
	}
	
	public void setBuf (int b) {
		buf = b;
	}

	public int getDamage () {
		double d = lowDamage + 0.5;
		double m = (double)((highDamage - lowDamage) / bellCurve);
		for (int i = 0; i < bellCurve; i++){
			d += m * Math.random();
		}
		
		d += buf / 2;
		return (int) d;

	}
	
	@Override
	public void affectEntity (Entity e) {
		super.affectEntity(e);
		e.onAttack(this);
	}
	
	@Override
	public void affectTile (Tile t) {
		super.affectTile(t);
		t.onAttack(this);
		if (t.getResidentEntity() != null) {
			affectEntity(t.getResidentEntity());
		}
	}
	
	@Override
	public BufferedImage getSprite() {
		return ImageManager.getEffectSprite("fire.png", 7 - currentFrame / 4, 0);
	}
	
}
