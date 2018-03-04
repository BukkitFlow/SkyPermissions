package de.danielflow.project.SkyPermissions.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.danielflow.project.SkyPermissions.PermissionsHandler.Group;


public class SQLmethods {
	
	public static boolean PermissionPlayerExists(String uuid) {
		
		
		try {
			ResultSet rs = MySQL.query("SELECT * FROM SkyPerms WHERE UUID= '" + uuid + "'");
			if(rs.next()) {
				

				return rs.getString("UUID") != null;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static void createPermissionPlayer(String uuid) {
		String group = getGroup(uuid);
		if(!(PermissionPlayerExists(uuid))) {
			
			MySQL.update("INSERT INTO SkyCraft(UUID, GROUP, PERMISSIONS, PREFIX) VALUES('"+ uuid+ "', 'DEFAULT', 'skycraft.default', '§7Golem'); ");
		}
		
	}
	
	/*- <! GET METHODEN # FÜR GROUP, PREMISSIONS & PREFIX !> -*/
	
	public static String getGroup(String uuid) {
		String group = "";
		if(PermissionPlayerExists(uuid)) {
			try {
				ResultSet rs = MySQL.query("SELECT * FROM SkyPerms WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (rs.getString("GROUP") == null));	
				group = rs.getString("GROUP");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			createPermissionPlayer(uuid);
			getGroup(uuid);
		}
		return group;
	}
	
	public static String getPermission(String uuid, String permission) {
		String perm = "";
		if(PermissionPlayerExists(uuid)) {
			try {
				ResultSet rs = MySQL.query("SELECT PERMISSIONS FROM SkyPerms WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (rs.getString("PERMISSIONS") == null));	
				perm = rs.getString("PERMISSIONS");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			createPermissionPlayer(uuid);
			getPermission(uuid, permission);
		}
		return perm;
	}
	
	public static String getPrefix(Group group) {
		String prefix = "";
		try {
			ResultSet rs = MySQL.query("SELECT PREFIX FROM SkyPerms WHERE GROUP= '" + group + "'");
			if((!rs.next()) || (rs.getString("PREFIX") == null));	
			prefix = rs.getString("PREFIX");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prefix;
	}
	
	/*- <! SET METHODEN # FÜR GROUP, PREMISSIONS & PREFIX !> -*/
	public static void setGroup(String uuid, Group group) {
		if(PermissionPlayerExists(uuid)) {
			MySQL.update("UPDATE SkyPerms SET GROUP= '" + group + "' WHERE UUID='" + uuid + "';");
		} else {
			createPermissionPlayer(uuid);
			setGroup(uuid, group);
		}
	}
	
	public static void setPermission(String uuid, String permission) {
		if(PermissionPlayerExists(uuid)) {
			MySQL.update("UPDATE SkyPerms SET PERMISSIONS= '" + permission + "' WHERE UUID='" + uuid + "';");
		} else {
			createPermissionPlayer(uuid);
			setPermission(uuid, permission);
		}
	}
}

//               TODO FINISH SQLmethods
	
	
	/*public static void setPoints(String uuid, Integer points) {
		if(PermissionPlayerExists(uuid)) {
			Database.update("UPDATE Stats SET POINTS= '" + points + "' WHERE UUID='" + uuid + "';");
		} else {
			createPermissionPlayer(uuid);
			setDeaths(uuid, points);
		}
	}
	
	
	public static void addKills(String uuid, Integer kills) {
		if(PermissionPlayerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid).intValue() + kills.intValue()));
		} else {
			createPermissionPlayer(uuid);
			addKills(uuid, kills);
		}
	}
	
	public static void addPoints(String uuid, Integer points) {
		if(PermissionPlayerExists(uuid)) {
			setPoints(uuid, Integer.valueOf(getPoints(uuid).intValue() + points.intValue()));
		} else {
			createPermissionPlayer(uuid);
			addPoints(uuid, points);
		}
	}
	
	public static void addDeaths(String uuid, Integer deaths) {
		if(PermissionPlayerExists(uuid)) {
			setDeaths(uuid, Integer.valueOf(getDeaths(uuid).intValue() + deaths.intValue()));
		} else {
			createPermissionPlayer(uuid);
			addDeaths(uuid, deaths);
		}
	}
	
	public static void removeKills(String uuid, Integer kills) {
		if(PermissionPlayerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid).intValue() - kills.intValue()));
		} else {
			createPermissionPlayer(uuid);
			removeKills(uuid, kills);
		}
	}
	
	public static void removePoints(String uuid, Integer points) {
		if(PermissionPlayerExists(uuid)) {
			setPoints(uuid, Integer.valueOf(getPoints(uuid).intValue() - points.intValue()));
		} else {
			createPermissionPlayer(uuid);
			addPoints(uuid, points);
		}
	}
	
	public static void removeDeaths(String uuid, Integer deaths) {
		if(PermissionPlayerExists(uuid)) {
			setDeaths(uuid, Integer.valueOf(getDeaths(uuid).intValue() - deaths.intValue()));
		} else {
			createPermissionPlayer(uuid);
			removeDeaths(uuid, deaths);
		}
	}
	
	
}*/
