package zoara.sfs2x.extension.handlers.player;

import zoara.sfs2x.extension.simulation.ActivePlayer;
import zoara.sfs2x.extension.simulation.World;
import zoara.sfs2x.extension.utils.RoomHelper;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class PlayerSkillHandler extends BaseClientRequestHandler
{
    @Override
    public void handleClientRequest(User user, ISFSObject data)
    {
    	trace("Received player skill setting: " + user.getId());
    	
		World world = RoomHelper.getWorld(this);
		ActivePlayer player = world.getPlayer(user);
		if (player == null)
			return;

		player.setSkill(data.getInt("skill"));
    }
}
