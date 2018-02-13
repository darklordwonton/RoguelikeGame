package main.magic;

import main.effects.Effect;
import main.effects.attacks.Attack;
import main.effects.attacks.EnumAttackType;
import main.entities.Entity;
import main.magic.shapes.Shape;
import main.magic.shapes.ShapeCenteredCircle;
import main.magic.shapes.ShapeLine;

//This class should be deleted as soon as possible, it's horrible and useless
//I'm only leaving it around for now for testing purposes
//-Simon
public class DamageSpell {
	protected static int value = 0;
	public static Spell createSpell(int v, Entity e){
		value = v;

		Shape s = determineShape(e);
		Attack ef = new Attack(1, 8, 1, null, e);
		ef.addType(EnumAttackType.FIRE);
		
		return new Spell(ef, s, "boo", e, 3);
	}
	
	public static Shape determineShape(Entity e){
		Shape s = new Shape(e, 0);
//		switch((int)(Math.random() * 2)) {
		switch(value) {
		case 0:
			s = new ShapeLine(e, 4, true, false);
			break;
		case 1:
			s = new ShapeCenteredCircle(e, 3);
			break;
		}
		
		return s;
	}


}
