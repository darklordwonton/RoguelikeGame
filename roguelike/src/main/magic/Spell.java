package main.magic;


import main.effects.Effect;
import main.entities.Entity;
import main.magic.shapes.Shape;
import main.rendering.MainRenderer;
import main.tiles.Tile;
import main.util.EnumDirection;

public class Spell {
	Effect[] effects = null;
	Shape shape = null;
	String name = "";
	int value = 0; //NOT IMPLEMENTED IN CURRENT DAMAGING SPELL GENERATOR 
	int manaCost = 0;
	
	Entity entity = null;
	
	public Spell(Effect[] ef, Shape s, String n, Entity e, int m){
		effects = ef;
		shape = s;
		name = n;
		entity = e;
		manaCost = m;
		
		value = 0;
	}
	
	public Spell(Effect ef, Shape s, String n, Entity e, int m){
		effects = new Effect[1];
		effects[0] = ef;
		shape = s;
		name = n;
		entity = e;
		manaCost = m;
		
		value = 0;
	}
	
	public void updateLocation(EnumDirection d){
		shape.setX(entity.getX());
		shape.setY(entity.getY());
		shape.setDirection(d);
	}

	public void cast(EnumDirection d) {
		/*List<int[]> l = squaresTargeted(entity.getX(), entity.getY(), EnumDirection.LEFT);
		for (int i = 0; i < l.size(); i++){
			Globals.currentFloor.getTile(l.get(i)[0], l.get(i)[1]).getResidentEntity().onAttack(attack);
		}*/
		if (entity.getMp() >= manaCost){
			updateLocation(d);
			for (Tile t : shape.getTilesAffected()) {
				for (Effect e : effects) {
					e.affectTile(t);
				}
			}
		} else {
			MainRenderer.addMessage("Insufficient mana");
		}
	}
}
