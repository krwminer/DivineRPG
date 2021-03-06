package naturix.divinerpg.events;

import java.io.IOException;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt) {
        EntityPlayer p = evt.player;
        if (!p.world.isRemote) {
            if (Config.UpdateChecker) {
                if (!UpdateChecker.isOnline() && !Config.canShowOverlay) {
                	Logging.message(p, TextFormatting.LIGHT_PURPLE + MessageLocalizer.normal("message.version.internet"));
                			
                } else if (UpdateChecker.isOnline() && UpdateChecker.isUpdateAvailable() && !Config.canShowOverlay) {
                	Logging.message(p, TextFormatting.RED + MessageLocalizer.normal("message.version.update"));
                    try {
                    Logging.message(p, TextFormatting.WHITE + MessageLocalizer.version(UpdateChecker.getCurrentVersion()));
                    } catch (IOException e) {
                    Logging.message(p, TextFormatting.LIGHT_PURPLE + MessageLocalizer.normal("message.version.internet"));
                    	}
                }
            }else {Logging.message(p, TextFormatting.AQUA + p.getDisplayName().getFormattedText() + " has the most recent version of DivineRPG installed!");}
            if (Utils.isDeveloperName(p.getCommandSenderEntity().getDisplayName())) {
            	Logging.message(p, TextFormatting.WHITE +	MessageLocalizer.normal("message.developer" + " is on the DivineRPG dev team"));
                Logging.message(p, "Welcome " + p.getDisplayName().getFormattedText());
            } else {
                Logging.message(p, "Welcome " + p.getDisplayName().getFormattedText());
            }
        }
        DivineRPG.logger.info("Current Version : " + DivineRPG.version);
		DivineRPG.logger.info("Is Online : " + UpdateChecker.isOnline());
		if(UpdateChecker.isOnline()) {
		DivineRPG.logger.info("Update Available : " + UpdateChecker.isUpdateAvailable());
		}
    }  		
}