package de.danielflow.project.SkyPermissions.PermissionsHandler;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import de.danielflow.project.SkyPermissions.SkyPerms;

public class HandlePermission {
	
    public static void setGroupPermissions(final Player p, Group Group){
    	
    	// !<PERMANENT IF SAVED ATTACHMENT>!
    	PermissionAttachment pa = p.addAttachment(SkyPerms.getInstance());
    	
        switch(Group){
        case DEFAULT:
        	//TODO MYSQL ADDEN
        	pa.setPermission("SkyCraft.default", true);
        	
            break;
            /* PAID*/
        case CREEPER:
        	//TODO MYSQL ADDEN
            break;
        case SHULKER:
        	//TODO MYSQL ADDEN
            break;
        case BLAZE:
        	//TODO MYSQL ADDEN
            break;
        case ENDERMAN:
        	//TODO MYSQL ADDEN
            break;
        case EVOKER:
        	//TODO MYSQL ADDEN
            break;
            
            /* LIMITED & ONLY GIVIN BY A ADMIN  */
        case SHEEP:
        	//TODO MYSQL ADDEN
            break;
        case SQUID:
        	//TODO MYSQL ADDEN
            break;
        case OZELOT:
        	//TODO MYSQL ADDEN
            break;
            
            /* VIP RANKS  */
        case PROPLAYER:
        	//TODO MYSQL ADDEN
            break;
        case STREAMER:
        	//TODO MYSQL ADDEN
            break;
        case YOUTUBER:
        	//TODO MYSQL ADDEN
            break;
            
            /* STAFF RANKS  */
        case SUPPORTER:
        	//TODO MYSQL ADDEN
            break;
        case BUILDER:
        	//TODO MYSQL ADDEN
            break;
        case MODERATOR:
        	//TODO MYSQL ADDEN
            break;
        case SENIORMODERATOR:
        	//TODO MYSQL ADDEN
            break;
        case GAMEADMIN:
        	//TODO MYSQL ADDEN
            break;
        case DEVELOPER:
        	//TODO MYSQL ADDEN
            break;
          //TODO MYSQL ADDEN
        case ADMIN:
            break;
            
        }
    }
    

}
