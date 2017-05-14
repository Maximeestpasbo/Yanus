package Model;

public class Potion extends Item //implements DemisableObserver, Demisable
{
	private int steplife;
	private int count;

	private Player player;

	public Potion(int posX, int posY, int count, Game game, int color, int step) {
		super(posX, posY, count, game, color);
		this.steplife = step;
		
		
	}

	public void gainlife(int steplife){
		if (count >0){
		player.Gain(steplife);
		count -=1;
		}
		else{
			game.removeObject(this);
		}
		System.out.println("count = "+ count + "vie =" + player.getLp());}
	@Override
	public void use(int playerNumber){
		this.player = (Player) game.getGameObjects().get(playerNumber);
		player.Gain(steplife);
		count -=1;
		System.out.println(player.getLp());
	}
	

}