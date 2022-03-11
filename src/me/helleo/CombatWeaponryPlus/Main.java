package me.helleo.CombatWeaponryPlus;
//Message: theres a lot of code and stuff with // before it, thats because those were things that were either there in a previous version, there to be tested, or didnt work and i didnt delete them for some reason
// also sorry if a lot of this stuff is messy, i dont really know what things are considered messy or not
// but it all works



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.AbstractArrow.PickupStatus;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;

import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;



public class Main extends JavaPlugin implements Listener {
	

	@Override
	public void onEnable() {
		
		Cooldown.setupCooldown();
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.saveDefaultConfig();
		
		//emeraldgear
		String ee = this.getConfig().getString("Emerald");
		if (ee == "true") {
			Bukkit.addRecipe(getRecipe());
		Bukkit.addRecipe(getChestplateRecipe());
		Bukkit.addRecipe(getLeggingsRecipe());
		Bukkit.addRecipe(getBootsRecipe());
		}
		if (this.getConfig().getString("EmeraldGear") == "true") {
			Bukkit.addRecipe(getPickaxeRecipe());
		Bukkit.addRecipe(getSwordRecipe());
		Bukkit.addRecipe(getAxeRecipe());
		Bukkit.addRecipe(getShovelRecipe());
		Bukkit.addRecipe(getHoeRecipe());
		
		}
		
		//swords
		String s = this.getConfig().getString("ChorusBlade");
		if (s == "true") {
			Bukkit.addRecipe(getSworddRecipe());
		}
		String s2 = this.getConfig().getString("SwordBow");
		if (s2 == "true") {
			Bukkit.addRecipe(getSwordbowRecipe());
		}
		String s3 = this.getConfig().getString("HeavySwordBow");
		if (s3 == "true") {
			Bukkit.addRecipe(getHSwordbowRecipe());
		}
		
		//chaimail
		String qq = this.getConfig().getString("Chainmail");
		if (qq == "true") {
			Bukkit.addRecipe(getChnHelmetRecipe());
		Bukkit.addRecipe(getChnChestRecipe());
		Bukkit.addRecipe(getChnLegRecipe());
		Bukkit.addRecipe(getChnBootsRecipe());
		}
		//platedchain
		String q1q = this.getConfig().getString("PlatedChainmail");
		if (q1q == "true") {
		Bukkit.addRecipe(getPChnHelmetRecipe());
		Bukkit.addRecipe(getPChnChestRecipe());
		Bukkit.addRecipe(getPChnLegRecipe());
		Bukkit.addRecipe(getPChnBootsRecipe());
		
		}
		
		
		
		//charms
		String fc = this.getConfig().getString("FeatherCharm");
		if (fc == "true") {
			Bukkit.addRecipe(getFCharmRecipe());
		}
		String ec = this.getConfig().getString("EmeraldCharm");
		if (ec == "true") {
			Bukkit.addRecipe(getECharmRecipe());
		}
		String bc = this.getConfig().getString("BlazeCharm");
		if (bc == "true") {
			Bukkit.addRecipe(getBCharmRecipe());
		}
		
		
		//scythes
		if (this.getConfig().getString("Scythes") == "true") {
			Bukkit.addRecipe(getWScytheRecipe());
		Bukkit.addRecipe(getSScytheRecipe());
		Bukkit.addRecipe(getGScytheRecipe());
		Bukkit.addRecipe(getIScytheRecipe());
		Bukkit.addRecipe(getDScytheRecipe());
		Bukkit.addRecipe(getNScytheRecipe());
		
		}
		if (this.getConfig().getString("EmeraldGear") == "true" && this.getConfig().getString("Scythes") == "true") {
			Bukkit.addRecipe(getEScytheRecipe());
		}
		//obbypick
		String breh = this.getConfig().getString("ObsidianPickaxe");
		if (breh == "true") {
			Bukkit.addRecipe(getobpickRecipe());
		}
		
		//rapiers
		if (this.getConfig().getString("Rapiers") == "true") {
			Bukkit.addRecipe(getRapierRecipe());
		Bukkit.addRecipe(getsRapierRecipe());
		Bukkit.addRecipe(getgRapierRecipe());
		Bukkit.addRecipe(getIRapierRecipe());
		
		Bukkit.addRecipe(getDRapierRecipe());
		Bukkit.addRecipe(getNRapierRecipe());
		}
		if (this.getConfig().getString("EmeraldGear") == "true" && this.getConfig().getString("Rapiers") == "true") {
			Bukkit.addRecipe(geteeRapierRecipe());
		}
		//longswords
		if (this.getConfig().getString("Longswords") == "true") {
			Bukkit.addRecipe(getwlongRecipe());
		Bukkit.addRecipe(getslongRecipe());
		Bukkit.addRecipe(getglongRecipe());
		Bukkit.addRecipe(getIlongRecipe());
		
		Bukkit.addRecipe(getDlongRecipe());
		Bukkit.addRecipe(getNlongRecipe());
		}
		if (this.getConfig().getString("EmeraldGear") == "true" && this.getConfig().getString("Longswords") == "true") {
			Bukkit.addRecipe(getelongRecipe());
		}
		//knifes
		if (this.getConfig().getString("Knives") == "true") {
			Bukkit.addRecipe(getwknifeRecipe());
		Bukkit.addRecipe(getsknifeRecipe());
		Bukkit.addRecipe(getgknifeRecipe());
		Bukkit.addRecipe(getIknifeRecipe());
		Bukkit.addRecipe(getDknifeRecipe());
		Bukkit.addRecipe(getNknifeRecipe());
		}
		if (this.getConfig().getString("Knives") == "true" && this.getConfig().getString("EmeraldGear") == "true") {

			Bukkit.addRecipe(geteknifeRecipe());
		}
		//spears
		if (this.getConfig().getString("Spears") == "true") {
			Bukkit.addRecipe(getwspearRecipe());
		Bukkit.addRecipe(getsspearRecipe());
		Bukkit.addRecipe(getgspearRecipe());
		Bukkit.addRecipe(getispearRecipe());
		Bukkit.addRecipe(getdspearRecipe());
		Bukkit.addRecipe(getnspearRecipe());
		
		}
		if (this.getConfig().getString("EmeraldGear") == "true" && this.getConfig().getString("Spears") == "true") {
			Bukkit.addRecipe(getespearRecipe());
		}
		//katanas
		if (this.getConfig().getString("Katanas") == "true") {
			Bukkit.addRecipe(getwkatRecipe());
		Bukkit.addRecipe(getgkatRecipe());
		Bukkit.addRecipe(getskatRecipe());
		Bukkit.addRecipe(getikatRecipe());
		
		Bukkit.addRecipe(getdkatRecipe());
		Bukkit.addRecipe(getnkatRecipe());
		}
		if (this.getConfig().getString("EmeraldGear") == "true" && this.getConfig().getString("Katanas") == "true") {
			Bukkit.addRecipe(getekatRecipe());
		}

		if (this.getConfig().getString("Prismarine") == "true") {

		
		Bukkit.addRecipe(getinsttRecipe());
		Bukkit.addRecipe(getprisswordsrecipe());
		Bukkit.addRecipe(getprispickrecipe());
		Bukkit.addRecipe(getprisaxerecipe());
		Bukkit.addRecipe(getprisshovelrecipe());
		Bukkit.addRecipe(getprishoerecipe());
		Bukkit.addRecipe(getprishelmetrecipe());
		Bukkit.addRecipe(getprischestrecipe());
		Bukkit.addRecipe(getprislegrecipe());
		Bukkit.addRecipe(getprisbootsrecipe());
		}
		
		if (this.getConfig().getString("Longbow") == "true") {
		
		Bukkit.addRecipe(getlbowinsttRecipe());
		}
		if (this.getConfig().getString("Recurvebow") == "true") {
			
			Bukkit.addRecipe(getrbowinsttRecipe());
			}
if (this.getConfig().getString("Compoundbow") == "true") {
			
			Bukkit.addRecipe(getcbowinsttRecipe());
			}
		
		//Bukkit.addRecipe(getTESTbowRecipe());
if (this.getConfig().getString("Eelytra") == "true") {		
Bukkit.addRecipe(getEelytraRecipe());
}

//Bukkit.addRecipe(geteaeaRecipe());
//Bukkit.addRecipe(gettestt());
if (this.getConfig().getString("ReallyGoodSword") == "true") {
Bukkit.addRecipe(getOPSWORDRecipe());
}
if (this.getConfig().getString("DiamondShield") == "true") {
Bukkit.addRecipe(getDiaShieldRecipe());
}
if (this.getConfig().getString("NetheriteShield") == "true") {
Bukkit.addRecipe(getNethShieldRecipe());
}
if (this.getConfig().getString("GoldCharm") == "true") {
Bukkit.addRecipe(getGCharmRecipe());
}
Bukkit.addRecipe(getawakswordsrecipe());
if (this.getConfig().getString("Sabers") == "true") {
Bukkit.addRecipe(getWSaberRecipe());
Bukkit.addRecipe(getGSaberRecipe());
Bukkit.addRecipe(getSSaberRecipe());
Bukkit.addRecipe(getISaberRecipe());
Bukkit.addRecipe(getDSaberRecipe());
Bukkit.addRecipe(getNSaberRecipe());
}
if (this.getConfig().getString("EmeraldGear") == "true" && this.getConfig().getString("Sabers") == "true") {
	Bukkit.addRecipe(getESaberRecipe());
}
if (this.getConfig().getString("StarCharm") == "true") {
Bukkit.addRecipe(getERecipe());
}
if (this.getConfig().getString("RepeatingCrossbow") == "true") {
	Bukkit.addRecipe(getrepcrossRecipe());
	
	}
if (this.getConfig().getString("BurstCrossbow") == "true") {
	Bukkit.addRecipe(getburscrossRecipe());
}
if (this.getConfig().getString("RedstoneCore") == "true") {
Bukkit.addRecipe(getRedPlateRecipe());
}
if (this.getConfig().getString("LongswordBow") == "true") {
Bukkit.addRecipe(getLsBowRecipe());
}
if (this.getConfig().getString("RedstoneBow") == "true") {
Bukkit.addRecipe(getRedstoneBowRecipe());
}
if (this.getConfig().getString("TridentBow") == "true") {
Bukkit.addRecipe(getTridentBowRecipe());
}

if (this.getConfig().getString("WitherArmor") == "true") {
Bukkit.addRecipe(getWitherHelmetRecipe());
Bukkit.addRecipe(getWitherChestRecipe());
Bukkit.addRecipe(getWitherLegRecipe());
Bukkit.addRecipe(getWitherBootsRecipe());

}
if (this.getConfig().getString("JumpElytra") == "true") {
Bukkit.addRecipe(jumpElytraRecipe());
}

	}
	
	@Override
	public void onDisable() {
		
	}
	public List<NamespacedKey> keys = new ArrayList<NamespacedKey>();
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		String s = this.getConfig().getString("ResourcePack");
		if (s == "true") { 
			player.setResourcePack(this.getConfig().getString("PackLink"));
		}
		
		player.discoverRecipes(keys);
		
	}
	
	
	public ShapedRecipe getRecipe() {
		
		//emerald helmet
		
		ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", this.getConfig().getInt("EmeraldHelmet.BonusHealth"), 
						Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Defense", this.getConfig().getInt("EmeraldHelmet.Armor"), 
				Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier2);
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Helmet");

		if (this.getConfig().getString("EnchantmentsOnEmeraldArmor") == "true") {
			int num = this.getConfig().getInt("EmeraldArmorEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldArmorEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_helmet");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("EEE", "E E", "   ");
		
		recipe.setIngredient('E', Material.EMERALD);
		
		return recipe;
		
		
	}
	
	
	
	public ShapedRecipe getChestplateRecipe() {
		
		//emerald chestplate
		
		ItemStack item = new ItemStack(Material.GOLDEN_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", this.getConfig().getInt("EmeraldChestplate.BonusHealth"), 
								Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Defense", this.getConfig().getInt("EmeraldChestplate.Armor"), 
				Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier2);
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Chestplate");
		if (this.getConfig().getString("EnchantmentsOnEmeraldArmor") == "true") {
			int num = this.getConfig().getInt("EmeraldArmorEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldArmorEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_chestplate");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("E E", "EEE", "EEE");
		
		recipe.setIngredient('E', Material.EMERALD);
		
		return recipe;
	}
	
	public ShapedRecipe getLeggingsRecipe() {
		
		//emerald leggings
		
		ItemStack item = new ItemStack(Material.GOLDEN_LEGGINGS);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", this.getConfig().getInt("EmeraldLeggings.BonusHealth"), 
								Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Defense", this.getConfig().getInt("EmeraldLeggings.Armor"), 
				Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier2);
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Leggings");
		if (this.getConfig().getString("EnchantmentsOnEmeraldArmor") == "true") {
			int num = this.getConfig().getInt("EmeraldArmorEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldArmorEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_leggings");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("EEE", "E E", "E E");
		
		recipe.setIngredient('E', Material.EMERALD);
		
		return recipe;
	}
	
	public ShapedRecipe getBootsRecipe() {
		
		//emerald boots
		
		ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", this.getConfig().getInt("EmeraldBoots.BonusHealth"), 
								Operation.ADD_NUMBER, EquipmentSlot.FEET);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Defense", this.getConfig().getInt("EmeraldBoots.Armor"), 
				Operation.ADD_NUMBER, EquipmentSlot.FEET);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier2);
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Boots");
		if (this.getConfig().getString("EnchantmentsOnEmeraldArmor") == "true") {
			int num = this.getConfig().getInt("EmeraldArmorEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldArmorEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_boots");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("   ", "E E", "E E");
		
		recipe.setIngredient('E', Material.EMERALD);
		
		return recipe;
	}
	
	public ShapedRecipe getPickaxeRecipe() {
		
		//emerald pickaxe
		
		ItemStack item = new ItemStack(Material.GOLDEN_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Pickaxe");
		if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
			int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_pickaxe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("EEE", " S ", " S ");
		
		recipe.setIngredient('E', Material.EMERALD);
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}
	
	public ShapedRecipe getSwordRecipe() {
		
		//emerald sword
		
		ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.2, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 5, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		//AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Movement Speed", 0.05, 
	//			Operation.ADD_NUMBER, EquipmentSlot.HAND);
		//meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&9 6 Attack Damage"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1.8 Attack Speed"));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Sword");
		meta.setCustomModelData(1000017);
		if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
			int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_sword");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" E ", " E ", " S ");
		
		recipe.setIngredient('E', Material.EMERALD);
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}
	
	public ShapedRecipe getAxeRecipe() {
		
		//emerald Axe
		
		ItemStack item = new ItemStack(Material.GOLDEN_AXE);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Axe");
		if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
			int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_axe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("EE ", "ES ", " S ");
		
		recipe.setIngredient('E', Material.EMERALD);
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}
	
	public ShapedRecipe getShovelRecipe() {
		
		//emerald shovel
		
		ItemStack item = new ItemStack(Material.GOLDEN_SHOVEL);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Shovel");
		if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
			int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_shovel");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" E ", " S ", " S ");
		
		recipe.setIngredient('E', Material.EMERALD);
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}

	public ShapedRecipe getHoeRecipe() {
	
		//emerald hoe
	
		ItemStack item = new ItemStack(Material.GOLDEN_HOE);
		ItemMeta meta = item.getItemMeta();
	
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Hoe");
		if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
			int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
	
		NamespacedKey key = new NamespacedKey(this, "emerald_hoe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("EE ", " S ", " S ");
		
		recipe.setIngredient('E', Material.EMERALD);
		recipe.setIngredient('S', Material.STICK);
	
		return recipe;
	}
	
	
	
	
	
	
	
	//SWORDS
	
	
	
	
	public ShapedRecipe getSworddRecipe() {
		
		//ChorusBlade
	
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = item.getItemMeta();
	
		meta.setDisplayName(ChatColor.DARK_PURPLE + "ChorusBlade");
		if (this.getConfig().getString("EnchantsChorusBlade") == "true") {
			int num = this.getConfig().getInt("ChorusEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("ChorusEnchantLevels.Knockback");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.KNOCKBACK, num2, true);
		}
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click) &a&oTeleport"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&72 second cooldown"));
		
		
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&9 4 Attack Damage"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&9 10 Attack Speed"));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", 1000, 
						Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
						Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		meta.setCustomModelData(1000007);
		item.setItemMeta(meta);
	
		NamespacedKey key = new NamespacedKey(this, "chorusblade");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape(" E ", "PCP", "qBq");
		
		recipe.setIngredient('E', Material.END_ROD);
		recipe.setIngredient('P', Material.ENDER_EYE);
		recipe.setIngredient('C', Material.CHORUS_FLOWER);
		recipe.setIngredient('B', Material.BLAZE_ROD);
		recipe.setIngredient('q', Material.END_CRYSTAL);
	
		return recipe;
	}
	
	@EventHandler()
	public void onClick(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD))
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000007) {
				Player player = (Player) event.getPlayer();
				//Right click
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.launchProjectile(EnderPearl.class);
						//player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 2));
						Cooldown.setCooldown(event.getPlayer(), 2);
						
					} else {
						return;
						
					}
					
					
					
				}
				
		
			}
		
	}
	
	public ShapedRecipe getSwordbowRecipe() {
		
		//sword bow
	
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
	
		meta.setDisplayName(ChatColor.GOLD + "Sword Bow");
		if (this.getConfig().getString("EnchantsSwordBow") == "true") {
			int num = this.getConfig().getInt("SbowEnchantLevels.Smite");
			int num2 = this.getConfig().getInt("SbowEnchantLevels.Unbreaking");
			
			int num4 = this.getConfig().getInt("SbowEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DAMAGE_UNDEAD, num, true);
		meta.addEnchant(Enchantment.DURABILITY, num2, true);
		meta.addEnchant(Enchantment.MENDING, num4, true);
		}
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7Combination of a sword and bow"));
		lore.add("");
		meta.setLore(lore);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
						Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 8, 
						Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		
	meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
	
		NamespacedKey key = new NamespacedKey(this, "sword_bow");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("ISs", "SCs", "ISs");
		
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('s', Material.STRING);
		recipe.setIngredient('I', Material.IRON_INGOT);
		recipe.setIngredient('C', Material.IRON_SWORD);
	
		return recipe;
	}
	
public ShapedRecipe getHSwordbowRecipe() {
		
		// heavy sword bow
	
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
	
		meta.setDisplayName(ChatColor.GOLD + "Heavy Sword Bow");
		if (this.getConfig().getString("EnchantsHeavySwordBow") == "true") {
			int num = this.getConfig().getInt("HSbowEnchantLevels.Power");
			int num2 = this.getConfig().getInt("HSbowEnchantLevels.Unbreaking");
			int num3 = this.getConfig().getInt("HSbowEnchantLevels.Smite");
			int num4 = this.getConfig().getInt("HSbowEnchantLevels.Mending");
			meta.addEnchant(Enchantment.ARROW_DAMAGE, num, true);
		meta.addEnchant(Enchantment.DURABILITY, num2, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, num3, true);
		meta.addEnchant(Enchantment.MENDING, num4, true);
		}
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7The Ultimate Bow"));
		lore.add("");
		meta.setLore(lore);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3.2, 
						Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 10, 
						Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		//speed
		AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Speed", -0.05, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
		AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), "Speed", -0.05, 
				Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier4);
		
		//knockback res
		AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), "KnockbackRes", 0.5, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier5);
		AttributeModifier modifier6 = new AttributeModifier(UUID.randomUUID(), "KnockbackRes", 0.5, 
				Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier6);
		
		meta.setCustomModelData(1000002);
		
	
		item.setItemMeta(meta);
	
		NamespacedKey key = new NamespacedKey(this, "heavy_sword_bow");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("ISs", "SCs", "ISs");
		
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('s', Material.CHAIN);
		recipe.setIngredient('I', Material.NETHERITE_SCRAP);
		recipe.setIngredient('C', Material.NETHERITE_SWORD);
	
		return recipe;
	}
	
	
	
	
	
	
	
	public ShapedRecipe getChnHelmetRecipe() {
		
		//chainmail armor
	
		ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
		
		NamespacedKey key = new NamespacedKey(this, "chainmail_helmet");
	keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("CCC", "C C", "   ");
		
		recipe.setIngredient('C', Material.CHAIN);
	
		return recipe;
	}
	
	public ShapedRecipe getChnChestRecipe() {
		
		//chainmail armor
	
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		
		NamespacedKey key = new NamespacedKey(this, "chainmail_chestplate");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("C C", "CCC", "CCC");
		
		recipe.setIngredient('C', Material.CHAIN);
	
		return recipe;
	}
	
	public ShapedRecipe getChnLegRecipe() {
		
		//chainmail armor
	
		ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		
		NamespacedKey key = new NamespacedKey(this, "chainmail_leggings");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("CCC", "C C", "C C");
		
		recipe.setIngredient('C', Material.CHAIN);
	
		return recipe;
	}
	
	public ShapedRecipe getChnBootsRecipe() {
		
		//chainmail armor
	
		ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
		
		NamespacedKey key = new NamespacedKey(this, "chainmail_boots");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("   ", "C C", "C C");
		
		recipe.setIngredient('C', Material.CHAIN);
	
		return recipe;
	}
	
	
	
	public ShapedRecipe getPChnHelmetRecipe() {
		
		//plated chainmail armor
	
		ItemStack item = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Defense", 4, 
				Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.setDisplayName(ChatColor.BOLD + "Plated Chainmail Helmet");
		if (this.getConfig().getString("EnchantsPlatedChainmail") == "true") {
			int num = this.getConfig().getInt("PChainEnchantLevels.Unbreaking");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		}
		
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "plated_chainmail_helmet");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("III", "IHI", "III");
		
		recipe.setIngredient('H', Material.CHAINMAIL_HELMET);
		recipe.setIngredient('I', Material.IRON_NUGGET);
	
		return recipe;
	}
	
	public ShapedRecipe getPChnChestRecipe() {
		
		//plated chainmail armor
	
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Defense", 6, 
				Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.setDisplayName(ChatColor.BOLD + "Plated Chainmail Chestplate");
		if (this.getConfig().getString("EnchantsPlatedChainmail") == "true") {
			int num = this.getConfig().getInt("PChainEnchantLevels.Unbreaking");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		}
		
		item.setItemMeta(meta);
		
		
		NamespacedKey key = new NamespacedKey(this, "plated_chainmail_chestplate");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("III", "ICI", "III");
		
		recipe.setIngredient('C', Material.CHAINMAIL_CHESTPLATE);
		recipe.setIngredient('I', Material.IRON_NUGGET);
	
		return recipe;
	}
	
	public ShapedRecipe getPChnLegRecipe() {
		
		//plated chainmail armor
	
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Defense", 6, 
				Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.setDisplayName(ChatColor.BOLD + "Plated Chainmail Leggings");
		if (this.getConfig().getString("EnchantsPlatedChainmail") == "true") {
			int num = this.getConfig().getInt("PChainEnchantLevels.Unbreaking");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		}
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "plated_chainmail_leggings");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("III", "ILI", "III");
		
		recipe.setIngredient('L', Material.CHAINMAIL_LEGGINGS);
		recipe.setIngredient('I', Material.IRON_NUGGET);
	
		return recipe;
	}
	
	public ShapedRecipe getPChnBootsRecipe() {
		
		//plated chainmail armor
	
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Defense", 4, 
				Operation.ADD_NUMBER, EquipmentSlot.FEET);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.setDisplayName(ChatColor.BOLD + "Plated Chainmail Boots");
		if (this.getConfig().getString("EnchantsPlatedChainmail") == "true") {
			int num = this.getConfig().getInt("PChainEnchantLevels.Unbreaking");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		}
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "plated_chainmail_boots");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("III", "IBI", "III");
		
		recipe.setIngredient('B', Material.CHAINMAIL_BOOTS);
		recipe.setIngredient('I', Material.IRON_NUGGET);
	
		return recipe;
	}
	
	
	
	//Scythes
	
	public ShapedRecipe getWScytheRecipe() {
		
		//wooden scythe
		
		ItemStack item = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenScythe.name")));
		meta.setCustomModelData(1000003);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "wooden_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("SSS", "  S", "  S");
		
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}
	
	public ShapedRecipe getSScytheRecipe() {
		
		//stone scythe
		
		ItemStack item = new ItemStack(Material.STONE_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6.5, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneScythe.name")));
		meta.setCustomModelData(1000003);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "stone_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("CCC", "  S", "  S");
		
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('C', Material.COBBLESTONE);
		
		return recipe;
	}
	
	public ShapedRecipe getGScytheRecipe() {
		
		//golden scythe
		
		ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldScythe.name")));
		meta.setCustomModelData(1000003);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "golden_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GGG", "  S", "  S");
		
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('G', Material.GOLD_INGOT);
		
		return recipe;
	}
	
public ShapedRecipe getEScytheRecipe() {
		
		//EMERALSSS scythe
		
		ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
			int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
			int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		meta.addEnchant(Enchantment.MENDING, num2, true);
		}
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 7, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldScythe.name")));
		meta.setCustomModelData(1000013);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("EEE", "  S", "  S");
		
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('E', Material.EMERALD);
		
		return recipe;
	}
	
public ShapedRecipe getIScytheRecipe() {
		
		//iron scythe
		
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 7, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronScythe.name")));
		meta.setCustomModelData(1000003);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "iron_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("III", "  S", "  S");
		
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('I', Material.IRON_INGOT);
		
		return recipe;
	}
	
	public ShapedRecipe getDScytheRecipe() {
	
		//diamond scythe
	
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondScythe.name")));
		meta.setCustomModelData(1000003);
		item.setItemMeta(meta);
	
		NamespacedKey key = new NamespacedKey(this, "diamond_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("DDD", "  S", "  S");
	
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('D', Material.DIAMOND);
	
		return recipe;
	}
	
	public ShapedRecipe getNScytheRecipe() {
		
		//netherite scythe
		
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 9, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteScythe.name")));
		meta.setCustomModelData(1000003);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "netherite_scythe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("NNN", "  S", "  S");
		
		recipe.setIngredient('S', Material.STICK);
		String n = this.getConfig().getString("NetheriteIngots");
		if (n == "true") {
			recipe.setIngredient('N', Material.NETHERITE_INGOT);
		} else {
			recipe.setIngredient('N', Material.NETHERITE_SCRAP);
		}
		
		
		return recipe;
	}
	
	public ShapedRecipe getobpickRecipe() {
		
		//obsidian pickaxe
	
		ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7Gives user Haste III"));
		lore.add("");
		meta.setLore(lore);
		
		if (this.getConfig().getString("EnchantsObsidianPick") == "true") {
			int num = this.getConfig().getInt("OPickEnchantLevels.Unbreaking");
			meta.addEnchant(Enchantment.DURABILITY, num, true);
		}
	
		
		
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Obsidian Pickaxe");
	meta.setCustomModelData(1000001);
		item.setItemMeta(meta);
	
		NamespacedKey key = new NamespacedKey(this, "obsidian_pickaxe");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("NON", " S ", " S ");
	
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('O', Material.CRYING_OBSIDIAN);
		recipe.setIngredient('N', Material.NETHERITE_INGOT);
		return recipe;
	}
	
	@EventHandler()
	public void oncClick(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_PICKAXE))
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000001) {
				//left click
				if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 2));
				}
			}
			}
	}
	@EventHandler()
	public void onccccClick(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_HOE))
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1234567) {
						World world = player.getWorld();
					world.playSound(player.getLocation(), Sound.MUSIC_DISC_CAT, 10, 1);
					ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
					meta.setDisplayName("GOTTEM");
					List<String> lore = new ArrayList<String>();
					lore.add("");
					lore.add(ChatColor.translateAlternateColorCodes('&', "&6im sorry"));
					lore.add("");
					meta.setLore(lore);
					meta.setCustomModelData(6969420);
					player.getInventory().getItemInMainHand().setItemMeta(meta);
					}
					
				}
			}
		
	}
	
	//longsword dash ability
	//unused
	
//	@EventHandler()
//	public void onccClick(PlayerInteractEvent event) {
//		Player player = event.getPlayer();
//		if (player.getInventory().getItemInMainHand().getItemMeta() != null)
//		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() == true)
//		if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
//			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000001 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200001 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000011) {
//				if (player.getInventory().getItemInOffHand().getType() != Material.SHIELD) {
//					if (event.getAction() == Action.RIGHT_CLICK_AIR) {
//						if (Cooldown.checkCooldown(event.getPlayer())) {
//							World world = (World) player.getWorld();
//							world.playSound(player.getLocation(), Sound.ENTITY_PHANTOM_FLAP, 10, 1);
//							player.setVelocity(player.getLocation().getDirection().multiply(1.1));
//							Cooldown.setCooldown(event.getPlayer(), 5);
//							
//						} else {
//							return;
//							
//						}
//						
///						return;
//				}
//			}	
//			}
		
//	}


	@EventHandler
	public void eeeeee(EntityDamageByEntityEvent event) {
		//KNIFE combo thing
		if (event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if (player.getInventory().getItemInMainHand().hasItemMeta())
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000006 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200006 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000016 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000006) {
				if (player.hasCooldown(Material.NETHERITE_SWORD) != true
						|| player.hasCooldown(Material.DIAMOND_SWORD) != true
						|| player.hasCooldown(Material.IRON_SWORD) != true
						|| player.hasCooldown(Material.GOLDEN_SWORD) != true
						|| player.hasCooldown(Material.STONE_SWORD) != true
						|| player.hasCooldown(Material.WOODEN_SWORD) != true) {
				player.setCooldown(Material.NETHERITE_SWORD, 20);
				player.setCooldown(Material.DIAMOND_SWORD, 20);
				player.setCooldown(Material.IRON_SWORD, 20);
				player.setCooldown(Material.GOLDEN_SWORD, 20);
				player.setCooldown(Material.STONE_SWORD, 20);
				player.setCooldown(Material.WOODEN_SWORD, 20);
				}
				if (player.hasCooldown(Material.NETHERITE_SWORD)
						|| player.hasCooldown(Material.DIAMOND_SWORD)
						|| player.hasCooldown(Material.IRON_SWORD)
						|| player.hasCooldown(Material.GOLDEN_SWORD)
						|| player.hasCooldown(Material.STONE_SWORD)
						|| player.hasCooldown(Material.WOODEN_SWORD)) {
					
					if (player.getCooldown(Material.NETHERITE_SWORD) <= 19
							|| player.getCooldown(Material.DIAMOND_SWORD) <= 19
							|| player.getCooldown(Material.IRON_SWORD) <= 19
							|| player.getCooldown(Material.GOLDEN_SWORD) <= 19
							|| player.getCooldown(Material.STONE_SWORD) <= 19
							|| player.getCooldown(Material.WOODEN_SWORD) <= 19) {
						
						player.setCooldown(Material.NETHERITE_SWORD, 19);
						player.setCooldown(Material.DIAMOND_SWORD, 19);
						player.setCooldown(Material.IRON_SWORD, 19);
						player.setCooldown(Material.GOLDEN_SWORD, 19);
						player.setCooldown(Material.STONE_SWORD, 19);
						player.setCooldown(Material.WOODEN_SWORD, 19);
						
						if (player.getAttackCooldown() <= 0.9) {
							return;
						}
					player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 0));
					
					}
					}
			
			}
		}
		}
		//saber dual wield thing
		//unused (made the sabers work a different way) i also dont really remember what this was specifically for
		//if (event.getDamager().getType().equals(EntityType.PLAYER)) {
		//if (player.getInventory().getItemInMainHand().hasItemMeta()) {
		//	if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
		//		if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000010
		//				|| player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200010) {
		//			if (player.getInventory().getItemInOffHand() != null)
		//			if (player.getInventory().getItemInOffHand().hasItemMeta())
		//				if (player.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData())
		//					if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010
		//							|| player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1200010) {
		//			if (player.getAttackCooldown() == 1.0) {
		//				event.setDamage(event.getDamage()/2);
		//			}
		//			if (player.getAttackCooldown() < 1.0 && player.getAttackCooldown() >= 0.9) {
		//				event.setDamage(event.getDamage()/1.8);
		//			}
		//			if (player.getAttackCooldown() < 0.9 && player.getAttackCooldown() >= 0.8) {
		//				event.setDamage(event.getDamage()/1.6);
		//			}
		//			if (player.getAttackCooldown() < 0.8 && player.getAttackCooldown() >= 0.7) {
		//				event.setDamage(event.getDamage()/1.4);
		//			}
		//			if (player.getAttackCooldown() < 0.7 && player.getAttackCooldown() >= 0.6) {
		//				event.setDamage(event.getDamage()/1.2);
		//			}
		//			if (player.getAttackCooldown() < 0.6 && player.getAttackCooldown() >= 0.5) {
		//				event.setDamage(event.getDamage()/1);
		//			}
		//					}
		//		}
		//	}
		//		}
		//}
		if (event.getEntity().getType().equals(EntityType.PLAYER)) {
			Player damaged = (Player) event.getEntity();
			if (damaged.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
				if (damaged.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
				if (damaged.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222225 || 
							damaged.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222225) {
						
						event.setDamage(event.getDamage()*1.5);
						
						
						
				}
			}
			}
		}
		if (event.getDamager().getType() == EntityType.PLAYER) {
			Player damager = (Player) event.getDamager();
			if (damager.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
				if (damager.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
					if (damager.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222224 || 
							damager.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222224) {
						
						LivingEntity entity = (LivingEntity) event.getEntity();
				        entity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
				        
					}
				}
			}
		}
		if (event.getDamager().getType() == EntityType.PLAYER) {
			Player damager = (Player) event.getDamager();
			if (damager.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
				if (damager.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
					if (damager.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222225 || 
							damager.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222225) {
						
						event.setDamage(event.getDamage()*1.5);
						
					}
				}
			}
		}
		
			//parry
			World world1 = (World) event.getEntity().getWorld();
			if (event.getEntity().getType() == EntityType.PLAYER) {
				Player player2 = (Player) event.getEntity();
				//vessel
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222223) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222223);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
				
					
							}
						}
					}
					//infvessel
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222224) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222224);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
				
					
							}
						}
					}
					//cursvessel
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222225) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222225);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
			
							}
						}
					}
				//awak ves
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222226) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222226);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					//double dmg1 = event.getDamage();
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
				
					
							}
						}
					}
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222227) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222227);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					//double dmg1 = event.getDamage();
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
				
					
							}
						}
					}
					//awakves 2
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222228) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222228);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					//double dmg1 = event.getDamage();
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
				
					
							}
						}
					}
					if (player2.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
						if (player2.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							if (player2.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222229) {
								ItemMeta meta = player2.getInventory().getItemInMainHand().getItemMeta();
								meta.setCustomModelData(2222229);
					player2.getInventory().getItemInMainHand().setItemMeta(meta);
					//double dmg1 = event.getDamage();
				event.setCancelled(true);
				world1.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BLOCK, 10, 1);
				
					
							}
						}
					}
			}
			
			
			
			
		//	}
			
		if (event.getDamager().getType() == EntityType.PLAYER) {
			Player player = (Player) event.getDamager();
			if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
				return;
			}
			if (player.getInventory().getItemInMainHand().getItemMeta() != null)
			if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() == true){
				
				//bone weapon ability test (damage increases when durability gets lower)
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000002
					|| player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000001
					|| player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000003
					|| player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000004
					|| player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000005
					|| player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000006)
					{
						//Player playerr = (Player) event.getDamager();
						double dmg = event.getDamage();
						org.bukkit.inventory.meta.Damageable test = (org.bukkit.inventory.meta.Damageable) player.getInventory().getItemInMainHand().getItemMeta();
						short timesused = (short) test.getDamage();
						short e = 250;
						short dur = (short) (e-timesused);
						
						double perc = (double) dur/e;
						double multiplier = 1-perc;
						double q = 1;
						double multiplierr = multiplier + q;
						event.setDamage(dmg*multiplierr);
						String string = String.valueOf(dmg*multiplierr);
						player.sendMessage(string);
						
						//BELOW: older version of above, newer version doesn't use .getDurability()
						//i changed it because .getDurability is deprecated, the newer version hasn't been tested yet, but the older version works correctly i think
						
						
						//double dmg = event.getDamage();
						//short timesused = player.getInventory().getItemInMainHand().getDurability();
						//short e = 250;
						//short dur = (short) (e-timesused);
						
						//double perc = (double) dur/e;
						//double multiplier = 1-perc;
					//	double q = 1;
					//	double multiplierr = multiplier + q;
					//	event.setDamage(dmg*multiplierr);
					//	String string = String.valueOf(dmg*multiplierr);
					//	player.sendMessage(string);
						
					}
				
				//rapeir
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000005 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200005 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000015 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000005) {
						
						event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);
					}
				
				//spear
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000004 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200004 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000014 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000004) {
						
						event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);
					}
				//longsword
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000001 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200001 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000011 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000001) 
						if (player.getInventory().getItemInOffHand().getType() == Material.AIR) {
							//OK IT WORKS
							//ok i think i fixed it but im not sure, need test
							//before: if (player.getInventory().getItemInOffHand() == null) {
							//doesnt work because the is air in offhand and air counts as item, figure out way to detect the air
							double dmg1 = event.getDamage();
							double bonus = dmg1 * 1.5;
							event.setDamage(bonus);
							//RNG CRIT
							//int random = getRandomInt(2);
							///if (random == 1) {
							//	double crit = bonus * 1.1;
							//	event.setDamage(crit);
							//	World world = (World) player.getWorld();
								
							//	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
							//	event.getEntity().getWorld().spawnParticle(Particle.SWEEP_ATTACK, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY() + 1, event.getEntity().getLocation().getZ(), 5);								
								
							//}
					}
				//scythe
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000003 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200003 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000013 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000003) 
						if (player.getInventory().getItemInOffHand().getType() == Material.AIR) {
							double dmg1 = event.getDamage();
							event.setDamage(dmg1 * 1.5);
					}
				//spear
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000004 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200004 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000014 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000004) 
						if (player.getInventory().getItemInOffHand().getType() == Material.AIR) {
							double dmg1 = event.getDamage();
							event.setDamage(dmg1 * 1.5);
					}
				//katana
				if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000002 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200002 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000012 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000002) 
						if (player.getInventory().getItemInOffHand().getType() == Material.AIR) {
							double dmg1 = event.getDamage();
							double bonus = dmg1 * 1.5;
							event.setDamage(bonus);
							//RNG CRIT
							int random = getRandomInt(5);
							if (random == 1) {
								double crit = bonus * 1.1;
								event.setDamage(crit);
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										World world = (World) player.getWorld();
								world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
								event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);								}
									}, 2L); //the 2L is ticks, there are 20 ticks in a second so this is 1/10th of a second delay
								
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										World world = (World) player.getWorld();
								world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
								event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);								}
									}, 4L);
								
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										World world = (World) player.getWorld();
								world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
								event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);								}
									}, 6L);
								
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										World world = (World) player.getWorld();
								world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
								event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);								}
									}, 8L);
								
								
								
							} 
							
							
					}
				
				if (event.getEntity() instanceof Player) {
					
					if (event.getCause() == DamageCause.ENTITY_ATTACK) {
						//rapier
						if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000005 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200005 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000015 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000005) {
								
								//event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);
								
								World world = (World) player.getWorld();
								Player player2 = (Player) event.getEntity();
								if (player2.isBlocking()) {
									//double dmg1 = event.getDamage();
									//event.setDamage(dmg1 * 3);
									if (player.getAttackCooldown() == 1.0) {
										player2.setCooldown(Material.SHIELD, 40);
									}
									
									world.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BREAK, 10, 1);
									return;
								}
								
								if (player2.getInventory().getHelmet() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								if (player2.getInventory().getChestplate() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								if (player2.getInventory().getLeggings() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								if (player2.getInventory().getBoots() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								
							
							}
						//SPEAR
						if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000004 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200004 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000014 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000004) {
								
								//event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(), event.getEntity().getLocation().getZ(), 1);
								
								World world = (World) player.getWorld();
								Player player2 = (Player) event.getEntity();
								if (player2.isBlocking()) {
									//double dmg1 = event.getDamage();
									//event.setDamage(dmg1 * 3);
									if (player.getAttackCooldown() == 1.0) {
									player2.setCooldown(Material.SHIELD, 20);
									}
									world.playSound(player2.getLocation(), Sound.ITEM_SHIELD_BREAK, 10, 1);
									return;
								}
								
								if (player2.getInventory().getHelmet() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								if (player2.getInventory().getChestplate() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								if (player2.getInventory().getLeggings() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								if (player2.getInventory().getBoots() != null) {
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.05);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								
							
							}
						//KNIFE
						if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000006 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200006 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000016 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000006) {
								World world = (World) player.getWorld();
								Player player2 = (Player) event.getEntity();
								
								
								if (player2.getInventory().getChestplate() == null || player2.getInventory().getChestplate().getType() == Material.ELYTRA)
								
								{
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 2);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								
							
							}
						//scythe
						if (player.getInventory().getItemInMainHand().getItemMeta().hasLore())
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000003 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200003 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000013 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4000003) {
								World world = (World) player.getWorld();
								Player player2 = (Player) event.getEntity();
								
								
								if (player2.getInventory().getChestplate() == null || player2.getInventory().getChestplate().getType() == Material.ELYTRA)
								{
									double dmg1 = event.getDamage();
									event.setDamage(dmg1 * 1.5);
									world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 10, 1);
									return;
								}
								
							
							}
						
								
							
							
						
			}
			
		}
		
		
			}
		}
	}
	
	//Random number thing for  crit
		public static Integer getRandomInt(Integer max) {
	        Random ran = new Random();
	        return ran.nextInt(max);
	      }
public ShapedRecipe getRapierRecipe() {
		
		//wood
		
		ItemStack item = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line1")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line2")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line3")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line4")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line5")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line6")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line7")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line8")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line9")));
		lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.line10")));
		meta.setLore(lore);
		//important:
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//modifier
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.1, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenRapier.name")));
		meta.setCustomModelData(1000005);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "wooden_rapier");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("  S", "SS ", "SS ");
		
		
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}

public ShapedRecipe getsRapierRecipe() {
	
	//stone
	
	ItemStack item = new ItemStack(Material.STONE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.line10")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneRapier.name")));
	meta.setCustomModelData(1000005);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "stone_rapier");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  C", "CC ", "SC ");
	
	recipe.setIngredient('C', Material.COBBLESTONE);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}



public ShapedRecipe getgRapierRecipe() {
	
	//gold
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.line10")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenRapier.name")));
	meta.setCustomModelData(1000005);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "golden_rapier");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  C", "CC ", "SC ");
	
	recipe.setIngredient('C', Material.GOLD_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
	
public ShapedRecipe getIRapierRecipe() {
	
	//iron
	
	ItemStack item = new ItemStack(Material.IRON_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.line10")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronRapier.name")));
	meta.setCustomModelData(1000005);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "iron_rapier");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  C", "CC ", "SC ");
	
	recipe.setIngredient('C', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe geteeRapierRecipe() {
	
	//emerald
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.line10")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldRapier.name")));
	meta.setCustomModelData(1000015);
	if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
		int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
		int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
		meta.addEnchant(Enchantment.DURABILITY, num, true);
	meta.addEnchant(Enchantment.MENDING, num2, true);
	}
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "emerald_rapier");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  C", "CC ", "SC ");
	
	recipe.setIngredient('C', Material.EMERALD);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getDRapierRecipe() {
	
	//diamond
	
	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.line10")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondRapier.name")));
	meta.setCustomModelData(1000005);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "diamond_rapier");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  C", "CC ", "SC ");
	
	recipe.setIngredient('C', Material.DIAMOND);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getNRapierRecipe() {
	
	//netehrite
	
	ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.line10")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteRapier.name")));
	meta.setCustomModelData(1000005);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "netherite_rapier");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  C", "CC ", "SC ");
	
	recipe.setIngredient('S', Material.STICK);
	String n = this.getConfig().getString("NetheriteIngots");
	if (n == "true") {
		recipe.setIngredient('C', Material.NETHERITE_INGOT);
	} else {
		recipe.setIngredient('C', Material.NETHERITE_SCRAP);
	}
	
	return recipe;
}

//LONGSWORDS



public ShapedRecipe getwlongRecipe() {
	
	//wood
	
	ItemStack item = new ItemStack(Material.WOODEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line4")));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&6Heavy Blow"));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&7- 50% chance to deal 10% more"));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&7  damage when two handed"));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&6Lunge"));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click to dash (5 second cooldown)"));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.line8")));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&9+1 Knockback Resistance"));
	//lore.add(ChatColor.translateAlternateColorCodes('&', "&9-0.05 Movement Speed"));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	//AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Speed", -0.05, 
	////		Operation.ADD_NUMBER, EquipmentSlot.HAND);
	//meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	//AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), "Knockback Res", 0.1, 
	//		Operation.ADD_NUMBER, EquipmentSlot.HAND);
	//meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier4);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenLongsword.name")));
	meta.setCustomModelData(1000001);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wooden_longsword");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" S ", " S ", "SSS");
	
	
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getslongRecipe() {

//stone

ItemStack item = new ItemStack(Material.STONE_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.line8")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneLongsword.name")));
meta.setCustomModelData(1000001);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "stone_longsword");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape(" C ", " C ", "CSC");

recipe.setIngredient('C', Material.COBBLESTONE);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getglongRecipe() {

//gold

ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.line8")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldLongsword.name")));
meta.setCustomModelData(1000001);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "golden_longsword");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape(" C ", " C ", "CSC");

recipe.setIngredient('C', Material.GOLD_INGOT);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getIlongRecipe() {

//iron

ItemStack item = new ItemStack(Material.IRON_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.line8")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

///modifier
AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
		Operation.ADD_NUMBER, EquipmentSlot.HAND);
meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6, 
		Operation.ADD_NUMBER, EquipmentSlot.HAND);
meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronLongsword.name")));
meta.setCustomModelData(1000001);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "iron_longsword");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape(" C ", " C ", "CSC");

recipe.setIngredient('C', Material.IRON_INGOT);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getelongRecipe() {

//emerald

ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.line8")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldLongsword.name")));
meta.setCustomModelData(1000011);
if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
	int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
	int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
	meta.addEnchant(Enchantment.DURABILITY, num, true);
meta.addEnchant(Enchantment.MENDING, num2, true);
}
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "emerald_longsword");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape(" C ", " C ", "CSC");

recipe.setIngredient('C', Material.EMERALD);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getDlongRecipe() {

//diamond

ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.line8")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 7, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondLongsword.name")));
meta.setCustomModelData(1000001);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "diamond_longsword");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape(" C ", " C ", "CSC");

recipe.setIngredient('C', Material.DIAMOND);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getNlongRecipe() {

//netehrite

ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.line8")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteLongsword.name")));
meta.setCustomModelData(1000001);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "netherite_longsword");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape(" C ", " C ", "CSC");
String n = this.getConfig().getString("NetheriteIngots");
if (n == "true") {
	recipe.setIngredient('C', Material.NETHERITE_INGOT);
} else {
	recipe.setIngredient('C', Material.NETHERITE_SCRAP);
}
recipe.setIngredient('S', Material.STICK);

return recipe;
}

//KNIVES

public ShapedRecipe getwknifeRecipe() {
	
	//wood
	
	ItemStack item = new ItemStack(Material.WOODEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.line9")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKnife.name")));
	meta.setCustomModelData(1000006);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wooden_knife");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("   ", " S ", " S ");
	
	
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getsknifeRecipe() {

//stone

ItemStack item = new ItemStack(Material.STONE_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line8")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.line9")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKnife.name")));
meta.setCustomModelData(1000006);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "stone_knife");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape("   ", " C ", " S ");

recipe.setIngredient('C', Material.COBBLESTONE);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getgknifeRecipe() {

//gold

ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line8")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.line9")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//modifier
	
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	

meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldKnife.name")));
meta.setCustomModelData(1000006);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "golden_knife");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape("   ", " C ", " S ");

recipe.setIngredient('C', Material.GOLD_INGOT);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getIknifeRecipe() {

//iron

ItemStack item = new ItemStack(Material.IRON_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line8")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.line9")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

///modifier
AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1, 
		Operation.ADD_NUMBER, EquipmentSlot.HAND);
meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2, 
		Operation.ADD_NUMBER, EquipmentSlot.HAND);
meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);


meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKnife.name")));
meta.setCustomModelData(1000006);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "iron_knife");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape("   ", " C ", " S ");

recipe.setIngredient('C', Material.IRON_INGOT);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe geteknifeRecipe() {

//emerald

ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line8")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.line9")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
//	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1, 
	//		Operation.ADD_NUMBER, EquipmentSlot.HAND);
//	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	

meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKnife.name")));
if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
	int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
	int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
	meta.addEnchant(Enchantment.DURABILITY, num, true);
meta.addEnchant(Enchantment.MENDING, num2, true);
}
meta.setCustomModelData(1000016);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "emerald_knife");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape("   ", " C ", " S ");

recipe.setIngredient('C', Material.EMERALD);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getDknifeRecipe() {

//diamond

ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line8")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.line9")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	

meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKnife.name")));
meta.setCustomModelData(1000006);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "diamond_knife");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape("   ", " C ", " S ");

recipe.setIngredient('C', Material.DIAMOND);
recipe.setIngredient('S', Material.STICK);

return recipe;
}

public ShapedRecipe getNknifeRecipe() {

//netehrite

ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
ItemMeta meta = item.getItemMeta();

List<String> lore = new ArrayList<String>();
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line1")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line2")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line3")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line4")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line5")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line6")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line7")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line8")));
lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.line9")));
meta.setLore(lore);
//important:
meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	

meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKnife.name")));
meta.setCustomModelData(1000006);
item.setItemMeta(meta);

NamespacedKey key = new NamespacedKey(this, "netherite_knife");
keys.add(key);
ShapedRecipe recipe = new ShapedRecipe(key, item);

recipe.shape("   ", " C ", " S ");
String n = this.getConfig().getString("NetheriteIngots");
if (n == "true") {
	recipe.setIngredient('C', Material.NETHERITE_INGOT);
} else {
	recipe.setIngredient('C', Material.NETHERITE_SCRAP);
}
recipe.setIngredient('S', Material.STICK);

return recipe;
}

//SPEARS
public ShapedRecipe getwspearRecipe() {
	
	//wood
	
	ItemStack item = new ItemStack(Material.WOODEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSpear.name")));
	meta.setCustomModelData(1000004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wooden_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" SS", " SS", "S  ");
	
	
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getsspearRecipe() {
	
	//stone
	
	ItemStack item = new ItemStack(Material.STONE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSpear.name")));
	meta.setCustomModelData(1000004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "stone_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" MM", " SM", "S  ");
	
	recipe.setIngredient('M', Material.COBBLESTONE);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getgspearRecipe() {
	
	//gold
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenSpear.name")));
	meta.setCustomModelData(1000004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "golden_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" MM", " SM", "S  ");
	
	recipe.setIngredient('M', Material.GOLD_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getispearRecipe() {
	
	//iron
	
	ItemStack item = new ItemStack(Material.IRON_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSpear.name")));
	meta.setCustomModelData(1000004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "iron_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" MM", " SM", "S  ");
	
	recipe.setIngredient('M', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getespearRecipe() {
	
	//emerald
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSpear.name")));
	meta.setCustomModelData(1000014);
	if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
		int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
		int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
		meta.addEnchant(Enchantment.DURABILITY, num, true);
	meta.addEnchant(Enchantment.MENDING, num2, true);
	}
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "emerald_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" MM", " SM", "S  ");
	
	recipe.setIngredient('M', Material.EMERALD);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getdspearRecipe() {
	
	//diamon
	
	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSpear.name")));
	meta.setCustomModelData(1000004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "diamond_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" MM", " SM", "S  ");
	
	recipe.setIngredient('M', Material.DIAMOND);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getnspearRecipe() {
	
	//netherite
	
	ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.line12")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -1.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSpear.name")));
	meta.setCustomModelData(1000004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "netherite_spear");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" MM", " SM", "S  ");
	String n = this.getConfig().getString("NetheriteIngots");
	if (n == "true") {
		recipe.setIngredient('M', Material.NETHERITE_INGOT);
	} else {
		recipe.setIngredient('M', Material.NETHERITE_SCRAP);
	}
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

//KATANAS
public ShapedRecipe getwkatRecipe() {
	
	//wood
	
	ItemStack item = new ItemStack(Material.WOODEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenKatana.name")));
	meta.setCustomModelData(1000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wooden_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  S", " S ", "S  ");
	
	
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getgkatRecipe() {
	
	//gold
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 2.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldenKatana.name")));
	meta.setCustomModelData(1000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "golden_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	
	recipe.setIngredient('M', Material.GOLD_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getskatRecipe() {
	
	//stone
	
	ItemStack item = new ItemStack(Material.STONE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneKatana.name")));
	meta.setCustomModelData(1000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "stone_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	
	recipe.setIngredient('M', Material.COBBLESTONE);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getikatRecipe() {
	
	//iron
	
	ItemStack item = new ItemStack(Material.IRON_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronKatana.name")));
	meta.setCustomModelData(1000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "iron_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	
	recipe.setIngredient('M', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getekatRecipe() {
	
	//em
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldKatana.name")));
	meta.setCustomModelData(1000012);
	if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
		int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
		int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
		meta.addEnchant(Enchantment.DURABILITY, num, true);
	meta.addEnchant(Enchantment.MENDING, num2, true);
	}
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "emerald_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	
	recipe.setIngredient('M', Material.EMERALD);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getdkatRecipe() {
	
	//diamon
	
	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondKatana.name")));
	meta.setCustomModelData(1000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "diamond_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	
	recipe.setIngredient('M', Material.DIAMOND);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getnkatRecipe() {
	
	//nethrite
	
	ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.line14")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Move SPeed", 0.02, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteKatana.name")));
	meta.setCustomModelData(1000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "netherite_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	String n = this.getConfig().getString("NetheriteIngots");
	if (n == "true") {
		recipe.setIngredient('M', Material.NETHERITE_INGOT);
	} else {
		recipe.setIngredient('M', Material.NETHERITE_SCRAP);
	}
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

	
	//CHARMS
	
	
	public ShapedRecipe getFCharmRecipe() {
		
		//feather charm
	
		ItemStack item = new ItemStack(Material.FEATHER);
		ItemMeta meta = item.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Negates fall damage when held in off hand");
		lore.add("");
		meta.setLore(lore);
		
		meta.setDisplayName(ChatColor.WHITE + "Feather Charm");
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "feather_charm");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("LLL", "LFL", "LLL");
		
		recipe.setIngredient('F', Material.FEATHER);
		recipe.setIngredient('L', Material.LAPIS_BLOCK);
	
		return recipe;
	}
	
	
	@EventHandler
	public void onFall(EntityDamageEvent event) {
		if (event.getEntity().getType() == EntityType.PLAYER) {
			Player player = (Player) event.getEntity();
			if (event.getCause() == DamageCause.FALL) {
				if (player.getInventory().getItemInOffHand() != null)
					if (player.getInventory().getItemInOffHand().getItemMeta() != null)
					if (player.getInventory().getItemInOffHand().getItemMeta().getDisplayName().contains("Feather Charm"))
						if (player.getInventory().getItemInOffHand().getItemMeta().hasLore()) {
							event.setCancelled(true);
						}
			}
		}
	}
	
	public ShapedRecipe getECharmRecipe() {
		
		//emerald charm
	
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", 4, 
						Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Increases health when held in off hand");
		lore.add("");
		meta.setLore(lore);
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "Emerald Charm");
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		//meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "emerald_charm");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("LLL", "LFL", "LLL");
		
		recipe.setIngredient('F', Material.EMERALD);
		recipe.setIngredient('L', Material.LAPIS_BLOCK);
	
		return recipe;
	}
	
	public ShapedRecipe getBCharmRecipe() {
		
	
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Damage", 4, 
						Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		//AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Health", -2, 
		//		Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		//meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier2);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Increases damage when held in offhand");
		meta.setLore(lore);
		
		meta.setDisplayName(ChatColor.GOLD + "Blaze Charm");
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "blaze_charm");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("LLL", "LBL", "LLL");
		
		recipe.setIngredient('B', Material.BLAZE_ROD);
		recipe.setIngredient('L', Material.LAPIS_BLOCK);
	
		return recipe;
	}
public ShapedRecipe getGCharmRecipe() {
		
		//gold charm
	
		ItemStack item = new ItemStack(Material.GOLD_INGOT);
		ItemMeta meta = item.getItemMeta();
		
		//modifier
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", 0.3, 
						Operation.MULTIPLY_SCALAR_1, EquipmentSlot.OFF_HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
		
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Increases attack speed when held in offhand");
		meta.setLore(lore);
		
		meta.setDisplayName(ChatColor.GOLD + "Gold Charm");
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "gold_charm");
		keys.add(key);
		ShapedRecipe recipe = new ShapedRecipe(key, item);
	
		recipe.shape("LLL", "LBL", "LLL");
		
		recipe.setIngredient('B', Material.GOLD_INGOT);
		recipe.setIngredient('L', Material.LAPIS_BLOCK);
	
		return recipe;
	}
	// below is test stuff, i dont remember what it was for

	//furnace recipe??
	
	//public FurnaceRecipe getffrecipe() {
	//	ItemStack result = new ItemStack(Material.PRISMARINE_CRYSTALS);
	//	ItemMeta meta = result.getItemMeta();
		
	//	List<String> lore = new ArrayList<String>();
	//	lore.add("");
	//	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "The shards of diamonds");
	//	lore.add("");
	//	meta.setLore(lore);
		
	//	meta.setDisplayName("Diamond Shard");
	//	meta.addEnchant(Enchantment.DURABILITY, 69, true);
	//	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	//	result.setItemMeta(meta);
	//	NamespacedKey key = new NamespacedKey(this, "diamond_shard");
	//	keys.add(key);
	//	FurnaceRecipe recipe = new FurnaceRecipe(key, result, Material.DIAMOND, 70, 200);
		//second last number is exp, last number is cooking time
	//	return recipe;
	//}

	
	
	//public SmithingRecipe getssssrecipe() {
		
	//	ItemStack result = new ItemStack(Material.PRISMARINE_CRYSTALS);
	//	ItemMeta meta = result.getItemMeta();
	//	meta.setDisplayName("Diamond Shard");
	//	meta.addEnchant(Enchantment.DAMAGE_ALL, 69, true);
	//	result.setItemMeta(meta);
	//	NamespacedKey key = new NamespacedKey(this, "diamond_shard");
		//keys.add(key);
	//	SmithingRecipe recipe = new SmithingRecipe(key, result, null, null);
	//	
	//	return recipe;
	//}
	
//public SmithingRecipe getsrecipe() {
	//	ItemStack result = new ItemStack(Material.WOODEN_SWORD);
		
	//	NamespacedKey key = new NamespacedKey(this, "diamond_bruh");
	//	keys.add(key);
		
//		ItemMeta meta = result.getItemMeta();
//		List<String> lore = new ArrayList<String>();
//		lore.add("");
//		lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "eee");
	//	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "gfhdfdghdhg");
	///	meta.setLore(lore);
		
	//	result.setItemMeta(meta);
	//	RecipeChoice bruh = new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD);
	//	RecipeChoice bruh2 = new RecipeChoice.MaterialChoice(Material.ACACIA_BOAT);
		//bruh is base, bruh2 is upgrade
//SmithingRecipe recipe = new SmithingRecipe(key, result, bruh, bruh2);
//		recipe.getResult().addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 21);
//		recipe.getResult().setAmount(34);
//		//second last is base, last is add thingy??
//		return recipe;
//	}

@EventHandler
void onSmithingTableEventSWORD(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1210001);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSword.name")));
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	List<String> lore = new ArrayList<String>();
	
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSword.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSword.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSword.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSword.line4")));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}

}

@EventHandler
void onSmithingTableEventLONGSWORD(PrepareSmithingEvent event) {
	//LONGSWORD
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }
  
  if(tool.getItemMeta().getCustomModelData() != 1000001 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200001);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.name")));
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineLongsword.line8")));
	
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
@EventHandler
void onSmithingTableEventSCYTHE(PrepareSmithingEvent event) {
	//SCYTHE
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }

  if(tool.getItemMeta().getCustomModelData() != 1000003 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200003);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.name")));
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineScythe.line10")));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
@EventHandler
void onSmithingTableEventRAPIER(PrepareSmithingEvent event) {
	//RAPIER
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }

  if(tool.getItemMeta().getCustomModelData() != 1000005 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200005);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.name")));
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineRapier.line10")));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
@EventHandler
void onSmithingTableEventSPEAR(PrepareSmithingEvent event) {
	//SPEAR
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }

  if(tool.getItemMeta().getCustomModelData() != 1000004 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200004);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.name")));
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSpear.line12")));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
@EventHandler
void onSmithingTableEventKATANA(PrepareSmithingEvent event) {
	//KATANA
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }

  if(tool.getItemMeta().getCustomModelData() != 1000002 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200002);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.name")));
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line9")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line10")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line11")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line12")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line13")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKatana.line14")));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
@EventHandler
void onSmithingTableEventKNIFE(PrepareSmithingEvent event) {
	//KATANA
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }

  if(tool.getItemMeta().getCustomModelData() != 1000006 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200006);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.name")));
  AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
  		Operation.ADD_NUMBER, EquipmentSlot.HAND);
  resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
  List<String> lore = new ArrayList<String>();
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line7")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line8")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineKnife.line9")));
  resultm.setLore(lore);
  //important:
  resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
@EventHandler
void onSmithingTableEventSABER(PrepareSmithingEvent event) {
	//saber
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  if(tool.getItemMeta().hasCustomModelData() == false) {
	    return;
	  }

  if(tool.getItemMeta().getCustomModelData() != 1000010 || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1200010);
  resultm.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.name")));
  AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
  		Operation.ADD_NUMBER, EquipmentSlot.HAND);
  resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
  List<String> lore = new ArrayList<String>();
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line1")));
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line2")));
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line3")));
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line4")));
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line5")));
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line6")));
  lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("PrismarineSaber.line7")));
  resultm.setLore(lore);
  //important:
  resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}

public SmithingRecipe getprisswordsrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "testtttttt"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventPICK(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_PICKAXE || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1210002);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Pickaxe");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -2.8, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	List<String> lore = new ArrayList<String>();
	
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 7 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1.2 Attack Speed"));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprispickrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "trtfyhxdhrtytt"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_PICKAXE),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventAXE(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_AXE || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1220001);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Axe");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 10, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	List<String> lore = new ArrayList<String>();
	
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 11 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1 Attack Speed"));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprisaxerecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "gxhtdhryrhfthy"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_AXE),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventSHOVEL(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SHOVEL || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1210004);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Axe");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 6.5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	List<String> lore = new ArrayList<String>();
	
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 7.5 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1 Attack Speed"));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprisshovelrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "testasfdeesafat"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_SHOVEL),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventHOE(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_HOE || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1210005);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Hoe");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	resultm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	
	
	List<String> lore = new ArrayList<String>();
	
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 2 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 4 Attack Speed"));
	resultm.setLore(lore);
	//important:
	resultm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
  result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprishoerecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "eeeqebhiugkjh"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_HOE),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventHELMET(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_HELMET || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1220001);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Helmet");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Armor", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HEAD);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Armor", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HEAD);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Armor", 0.1, 
			Operation.ADD_NUMBER, EquipmentSlot.HEAD);
	resultm.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier3);
	AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), "Armor", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.HEAD);
	resultm.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier4);
	
	result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprishelmetrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "eewdweewettthidjh"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventCHESTPLATE(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_CHESTPLATE || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1220002);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Chestplate");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Armor", 9, 
			Operation.ADD_NUMBER, EquipmentSlot.CHEST);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Armor", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.CHEST);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Armor", 0.1, 
			Operation.ADD_NUMBER, EquipmentSlot.CHEST);
	resultm.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier3);
	AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), "Armor", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.CHEST);
	resultm.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier4);
	result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprischestrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "eeettthidjh"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventLEGGINGS(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_LEGGINGS || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1220003);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Leggings");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Armor", 7, 
			Operation.ADD_NUMBER, EquipmentSlot.LEGS);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Armor", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.LEGS);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Armor", 0.1, 
			Operation.ADD_NUMBER, EquipmentSlot.LEGS);
	resultm.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier3);
	AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), "Armor", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.LEGS);
	resultm.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier4);
	result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprislegrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "eegsrhgf"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}
@EventHandler
void onSmithingTableEventBOOTS(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_BOOTS || modifier.getType() != Material.PRISMARINE_SHARD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() == true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }

  ItemStack result = tool.clone();
  ItemMeta resultm = result.getItemMeta();
  resultm.setCustomModelData(1220004);
  resultm.setDisplayName(ChatColor.GREEN + "Prismarine Boots");
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Armor", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.FEET);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Armor", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.FEET);
	resultm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier2);
	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Armor", 0.1, 
			Operation.ADD_NUMBER, EquipmentSlot.FEET);
	resultm.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier3);
	AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), "Armor", 1, 
			Operation.ADD_NUMBER, EquipmentSlot.FEET);
	resultm.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier4);
	result.setItemMeta(resultm);
  
if (this.getConfig().getString("Prismarine") == "true") {
	  event.setResult(result);
}
}
public SmithingRecipe getprisbootsrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "eedadwasrhgf"),
		      new ItemStack(Material.AIR), // any material seems fine
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS),
	      new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD)
	     );
	    
	    return recipe;
}


public ShapedRecipe getinsttRecipe() {
	

	ItemStack item = new ItemStack(Material.PRISMARINE_SHARD);
	ItemMeta meta = item.getItemMeta();
	meta.setCustomModelData(9999901);
	List<String> lore = new ArrayList<String>();
	
	lore.add("");
	lore.add(ChatColor.GRAY + "Use in a smithing table to upgrade");
	lore.add(ChatColor.GRAY + "netherite armor/tools");

	lore.add("");

	meta.setLore(lore);
	
	meta.setDisplayName(ChatColor.GREEN + "Prismarine Alloy");
	meta.addEnchant(Enchantment.DURABILITY, 5, true);
	meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "prisupgrade");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);

	recipe.shape("LCL", "IBI", "LDL");
	
	recipe.setIngredient('B', Material.NETHERITE_INGOT);
	recipe.setIngredient('L', Material.PRISMARINE_SHARD);
	recipe.setIngredient('D', Material.DIAMOND_BLOCK);
	recipe.setIngredient('I', Material.IRON_BLOCK);
	recipe.setIngredient('C', Material.PRISMARINE_CRYSTALS);

	return recipe;
}



//public ShapedRecipe getTESTbowRecipe() {
	
	//TEST bow

	//ItemStack item = new ItemStack(Material.BOW);
	//ItemMeta meta = item.getItemMeta();

//	meta.setDisplayName(ChatColor.GOLD + "Test Bow");
	
	//List<String> lore = new ArrayList<String>();
//	lore.add("");
//	lore.add(ChatColor.translateAlternateColorCodes('&', "&7Increases arrow velocity"));
//	lore.add("");
//	meta.setLore(lore);
	
	//modifier
	//AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -3, 
	//				Operation.ADD_NUMBER, EquipmentSlot.HAND);
	//meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	//AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 8, 
	//				Operation.ADD_NUMBER, EquipmentSlot.HAND);
	//meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	
	
//meta.setCustomModelData(1069691);
//	item.setItemMeta(meta);

	//NamespacedKey key = new NamespacedKey(this, "test_bow");
	//keys.add(key);
//	ShapedRecipe recipe = new ShapedRecipe(key, item);

//	recipe.shape("SSS", "SBS", "SSS");
	
	//recipe.setIngredient('S', Material.EXPERIENCE_BOTTLE);
	//recipe.setIngredient('B', Material.BOW);

	//return recipe;
//}

@EventHandler
public void playerBowShoot(EntityShootBowEvent event) {
	Entity entity = event.getEntity();
	Float speed = event.getForce();
	Entity arrow = event.getProjectile();
	if (entity.getType().equals(EntityType.PLAYER) ) {
		Player player = (Player) entity;
		if (player.getInventory().getItemInOffHand().getType() == Material.BOW || player.getInventory().getItemInOffHand().getType() == Material.CROSSBOW) {
			return;
		}
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			
			//TEST BOW
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1069691) {//||player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1069691) {
			Vector vector = player.getLocation().getDirection();
			//these numbers make it around the same velocity as normal bows i think
			//arrow.setVelocity(new Vector
			//(vector.getX() * speed * 3.5,
			//vector.getY() * speed * 4,
			//vector.getZ()* speed * 3.5));
			World world = player.getWorld();
			arrow.setVelocity(new Vector
			(vector.getX() * speed * 5,
			vector.getY() * speed * 5,
			vector.getZ()* speed * 5));
			
			Trident trident = player.launchProjectile(Trident.class, arrow.getVelocity());
			arrow.remove();
			trident.setPierceLevel(20);
			trident.setCritical(true);
			trident.setFireTicks(100);
			trident.setGravity(false);
			trident.setPickupStatus(PickupStatus.DISALLOWED);
			trident.setBounce(false);
			trident.setCustomName("Bob");
			trident.setCustomNameVisible(true);
			trident.setKnockbackStrength(10);
			world.playSound(player.getLocation(), Sound.ITEM_TRIDENT_THROW, 10, 1);
			
			Entity pig = world.spawnEntity(player.getLocation().add(0, 9, 0), EntityType.PIG);
			pig.setCustomName("Kevin");
			pig.setCustomNameVisible(true);
			Entity chicken = world.spawnEntity(player.getLocation().add(0, 9, 0), EntityType.CHICKEN);
			chicken.setCustomName("Phil");
			chicken.setCustomNameVisible(true);
			
			pig.addPassenger(chicken);
			trident.addPassenger(pig);
			
			
			return;
			} 
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1069691) {// || player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() != 1069691) {
				
				// LONG BOW
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330001 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330004) {//||player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 3330001) {
				Vector vector = player.getLocation().getDirection();
				//these numbers make it around the same velocity as normal bows
				//arrow.setVelocity(new Vector
				//(vector.getX() * speed * 3.5,
				//vector.getY() * speed * 4,
				//vector.getZ()* speed * 3.5));
				arrow.setVelocity(new Vector
				(vector.getX() * speed * 4,
				vector.getY() * speed * 4,
				vector.getZ()* speed * 4));
				return;
				} 
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 3330001 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 3330004) {// || player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() != 3330001) {
				// RBOW
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330002) {//||player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 3330002) {
				Vector vector = player.getLocation().getDirection();
				//these numbers make it around the same velocity as normal bows
				//arrow.setVelocity(new Vector
				//(vector.getX() * speed * 3.5,
				//vector.getY() * speed * 4,
				//vector.getZ()* speed * 3.5));
				arrow.setVelocity(new Vector
				(vector.getX() * speed * 5,
				vector.getY() * speed * 5,
				vector.getZ()* speed * 5));
				return;
				} 
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 3330002) {//|| player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() != 3330002) {
				//CBow
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330003) {//||player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 3330003) {
					Vector vector = player.getLocation().getDirection();
					//these numbers make it around the same velocity as normal bows
					//arrow.setVelocity(new Vector
					//(vector.getX() * speed * 3.5,
					//vector.getY() * speed * 4,
					//vector.getZ()* speed * 3.5));
					arrow.setVelocity(new Vector
					(vector.getX() * speed * 6,
					vector.getY() * speed * 6,
					vector.getZ()* speed * 6));
					return;
					} 
				return;
			}
				return;
			}
			
			
			return;
			} 
				return;
			}  return;
			
			
			  
		} else return;

}  
		
	


@EventHandler
public void onCraftingLbowevent(PrepareItemCraftEvent event) {
    CraftingInventory inventory = event.getInventory();
    ItemStack[] items = inventory.getMatrix();

    //Crafting table be like: 0, 1, 2
    //                        3, 4, 5
    //                        6, 7, 8
    
    
    if (items[0] != null && items[0].getType() == Material.IRON_INGOT && items[0].getAmount() == 1
            && items[1] != null && items[1].getType() == Material.STICK && items[1].getAmount() == 1
            && items[2] != null && items[2].getType() == Material.IRON_INGOT && items[2].getAmount() == 1
            && items[3] != null && items[3].getType() == Material.STICK && items[3].getAmount() == 1
            && items[4] != null && items[4].getType() == Material.BOW && items[4].getAmount() == 1
            && items[5] != null && items[5].getType() == Material.STICK && items[5].getAmount() == 1
            && items[6] != null && items[6].getType() == Material.IRON_INGOT && items[6].getAmount() == 1
            && items[7] != null && items[7].getType() == Material.STICK && items[7].getAmount() == 1
            && items[8] != null && items[8].getType() == Material.IRON_INGOT && items[8].getAmount() == 1) {
    	ItemMeta meta = items[4].getItemMeta();
    	ItemStack item = new ItemStack(Material.BOW);
    	item.setItemMeta(meta);
    	
    	if (items[4].getType() == Material.BOW && items[4].getItemMeta().hasCustomModelData() == false) {
    		ItemMeta meta2 = item.getItemMeta();
    	meta2.setCustomModelData(3330001);
    	meta2.setDisplayName("Longbow");
	    	
    	List<String> lore = new ArrayList<String>();
    	lore.add("");
    	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strong Shot"));
    	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Slightly increased arrow velocity"));
    	lore.add("");
    	meta2.setLore(lore);
    	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Speed", -0.01, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
    	item.setItemMeta(meta2);
    	}
    	if (this.getConfig().getString("Longbow") == "true") {
			event.getInventory().setResult(item);
	}
    	 if (event.getInventory().getResult() != null) {
     		items[0].setAmount(0);
     		items[1].setAmount(0);
     		items[2].setAmount(0);
     		items[3].setAmount(0);
     		//items[4].setAmount(0);
     		items[5].setAmount(0);
     		items[6].setAmount(0);
     		items[7].setAmount(0);
     		items[8].setAmount(0);
     	}
    }
}

public ShapedRecipe getlbowinsttRecipe() {
	
	//instructions long bow

	ItemStack item = new ItemStack(Material.BOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	

	lore.add("");
	lore.add(ChatColor.GRAY + "HOW TO CRAFT:");
	lore.add(ChatColor.GRAY + "Put a bow in the center");
	lore.add(ChatColor.GRAY + "Click on the icon to see the materials");
	lore.add("");
	lore.add("This recipe can only be made one at a time.");
	lore.add("Additionally, the materials will disappear");
	lore.add("after the recipe is completed.");

	meta.setLore(lore);
	
	meta.setDisplayName(ChatColor.GOLD + "Longbow RECIPE");
	meta.setCustomModelData(3330001);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "instructionslongbow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);

	recipe.shape("LCL", "CBC", "LCL");
	
	recipe.setIngredient('B', Material.BEDROCK);
	recipe.setIngredient('L', Material.IRON_INGOT);
	recipe.setIngredient('C', Material.STICK);

	return recipe;
}


@EventHandler
public void onCraftingRbowevent(PrepareItemCraftEvent event) {
    CraftingInventory inventory = event.getInventory();
    ItemStack[] items = inventory.getMatrix();

    //Crafting table be like: 0, 1, 2
    //                        3, 4, 5
    //                        6, 7, 8
    
    
    if (items[0] != null && items[0].getType() == Material.IRON_BARS && items[0].getAmount() == 1
            && items[1] != null && items[1].getType() == Material.CRIMSON_STEM && items[1].getAmount() == 1
            && items[2] != null && items[2].getType() == Material.IRON_BARS && items[2].getAmount() == 1
            && items[3] != null && items[3].getType() == Material.CRIMSON_STEM && items[3].getAmount() == 1
            && items[4] != null && items[4].getType() == Material.BOW && items[4].getItemMeta().hasCustomModelData() && items[4].getItemMeta().getCustomModelData() == 3330001
            && items[5] != null && items[5].getType() == Material.WARPED_STEM && items[5].getAmount() == 1
            && items[6] != null && items[6].getType() == Material.IRON_BARS && items[6].getAmount() == 1
            && items[7] != null && items[7].getType() == Material.WARPED_STEM && items[7].getAmount() == 1
            && items[8] != null && items[8].getType() == Material.IRON_BARS && items[8].getAmount() == 1) {
    	ItemMeta meta = items[4].getItemMeta();
    	ItemStack item = new ItemStack(Material.BOW);
    	item.setItemMeta(meta);
    	
    	if (items[4].getType() == Material.BOW && items[4].getItemMeta().hasCustomModelData() == true && items[4].getItemMeta().getCustomModelData() == 3330001) {
    		ItemMeta meta2 = item.getItemMeta();
    	meta2.setCustomModelData(3330002);
    	meta2.setDisplayName("Recurve bow");
	    	
    	List<String> lore = new ArrayList<String>();
    	lore.add("");
    	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Sharp Shot"));
    	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Increased arrow velocity"));
    	lore.add("");
    	meta2.setLore(lore);
    	
    	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Speed", -0.01, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
    	item.setItemMeta(meta2);
    	}
    	if (this.getConfig().getString("Recurvebow") == "true") {
			event.getInventory().setResult(item);
	}
    	 if (event.getInventory().getResult() != null) {
     		items[0].setAmount(0);
     		items[1].setAmount(0);
     		items[2].setAmount(0);
     		items[3].setAmount(0);
     		//items[4].setAmount(0);
     		items[5].setAmount(0);
     		items[6].setAmount(0);
     		items[7].setAmount(0);
     		items[8].setAmount(0);
     	}
    }
}

public ShapedRecipe getrbowinsttRecipe() {
	
	//instructions recurve bow

	ItemStack item = new ItemStack(Material.BOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	
	//lore.add(ChatColor.GOLD + "The recipe is color coded:");
	lore.add("");
	lore.add(ChatColor.GRAY + "HOW TO CRAFT:");
	lore.add(ChatColor.GRAY + "Put a longbow in the center");
	lore.add(ChatColor.GRAY + "Click on the icon to see the materials");
	lore.add("");
	lore.add("This recipe can only be made one at a time.");
	lore.add("Additionally, the materials will disappear");
	lore.add("after the recipe is completed.");

	meta.setLore(lore);
	
	meta.setDisplayName(ChatColor.GOLD + "Recurve bow RECIPE");
	meta.setCustomModelData(3330002);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "instructionsrecbow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);

	recipe.shape("LCL", "CBQ", "LQL");
	
	recipe.setIngredient('B', Material.BEDROCK);
	recipe.setIngredient('C', Material.CRIMSON_STEM);
	recipe.setIngredient('Q', Material.WARPED_STEM);
	recipe.setIngredient('L', Material.IRON_BARS);

	return recipe;
}

@EventHandler
public void onCraftingCbowevent(PrepareItemCraftEvent event) {
    CraftingInventory inventory = event.getInventory();
    ItemStack[] items = inventory.getMatrix();

    //Crafting table be like: 0, 1, 2
    //                        3, 4, 5
    //                        6, 7, 8
    
    
    if (items[0] != null && items[0].getType() == Material.IRON_BLOCK && items[0].getAmount() == 1
            && items[1] != null && items[1].getType() == Material.NETHERITE_INGOT && items[1].getAmount() == 1
            && items[2] != null && items[2].getType() == Material.IRON_BLOCK && items[2].getAmount() == 1
            && items[3] != null && items[3].getType() == Material.NETHERITE_INGOT && items[3].getAmount() == 1
            && items[4] != null && items[4].getType() == Material.BOW && items[4].getItemMeta().hasCustomModelData() && items[4].getItemMeta().getCustomModelData() == 3330002
            && items[5] != null && items[5].getType() == Material.NETHERITE_INGOT && items[5].getAmount() == 1
            && items[6] != null && items[6].getType() == Material.IRON_BLOCK && items[6].getAmount() == 1
            && items[7] != null && items[7].getType() == Material.NETHERITE_INGOT && items[7].getAmount() == 1
            && items[8] != null && items[8].getType() == Material.IRON_BLOCK && items[8].getAmount() == 1) {
    	ItemMeta meta = items[4].getItemMeta();
    	ItemStack item = new ItemStack(Material.BOW);
    	item.setItemMeta(meta);
    	
    	if (items[4].getType() == Material.BOW && items[4].getItemMeta().hasCustomModelData() == true && items[4].getItemMeta().getCustomModelData() == 3330002) {
    		ItemMeta meta2 = item.getItemMeta();
    	meta2.setCustomModelData(3330003);
    	meta2.setDisplayName("Compound bow");
	    	
    	List<String> lore = new ArrayList<String>();
    	lore.add("");
    	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strike Shot"));
    	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Greatly increased arrow velocity"));
    	lore.add("");
    	meta2.setLore(lore);
    	
    	AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "Speed", -0.01, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta2.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
    	item.setItemMeta(meta2);
    	}
    	if (this.getConfig().getString("Compoundbow") == "true") {
			event.getInventory().setResult(item);
	}
    	 if (event.getInventory().getResult() != null) {
     		items[0].setAmount(0);
     		items[1].setAmount(0);
     		items[2].setAmount(0);
     		items[3].setAmount(0);
     		//items[4].setAmount(0);
     		items[5].setAmount(0);
     		items[6].setAmount(0);
     		items[7].setAmount(0);
     		items[8].setAmount(0);
     	}
    }
}

public ShapedRecipe getcbowinsttRecipe() {
	
	//instructions compound bow

	ItemStack item = new ItemStack(Material.BOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	
	//lore.add(ChatColor.GOLD + "The recipe is color coded:");
	lore.add("");
	lore.add(ChatColor.GRAY + "HOW TO CRAFT:");
	lore.add(ChatColor.GRAY + "Put a recurve bow in the center");
	lore.add(ChatColor.GRAY + "Click on the icon to see the materials");
	lore.add("");
	lore.add("This recipe can only be made one at a time.");
	lore.add("Additionally, the materials will disappear");
	lore.add("after the recipe is completed.");

	meta.setLore(lore);
	
	meta.setDisplayName(ChatColor.GOLD + "Compound bow RECIPE");
	meta.setCustomModelData(3330003);
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "instructionscompbow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);

	recipe.shape("LCL", "CBC", "LCL");
	
	recipe.setIngredient('B', Material.BEDROCK);
	recipe.setIngredient('C', Material.NETHERITE_INGOT);
	recipe.setIngredient('L', Material.IRON_BLOCK);

	return recipe;
}

public ShapedRecipe getEelytraRecipe() {
	
	//test elytra

	ItemStack item = new ItemStack(Material.ELYTRA);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();

	lore.add("");

	lore.add(ChatColor.GRAY + "test");
	lore.add(ChatColor.GRAY + "(not really meant to be");
	lore.add(ChatColor.GRAY + "obtainable yet but you can");
	lore.add(ChatColor.GRAY + "test it in creative or something)");
	lore.add("");

	meta.setLore(lore);
	
	meta.setDisplayName(ChatColor.GOLD + "Eelytra");
	meta.setCustomModelData(1560001);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "eelytra");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);

	recipe.shape("LCL", "CBC", "LCL");
	
	recipe.setIngredient('B', Material.ELYTRA);
	recipe.setIngredient('C', Material.EXPERIENCE_BOTTLE);
	recipe.setIngredient('L', Material.BEDROCK);

	return recipe;
}

@EventHandler()
public void oncccClick(PlayerInteractEvent event) {
	Player player = event.getPlayer();
	if (player.getInventory().getChestplate() != null)
	if (player.getInventory().getChestplate().getItemMeta() != null)
	if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true)
	if (player.getInventory().getChestplate().getItemMeta().hasLore())
		if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1560001) {
		     	
				if (event.getAction() == Action.RIGHT_CLICK_AIR && player.isGliding()) {
					player.sendMessage("qqq");
					
					ItemMeta meta = player.getInventory().getChestplate().getItemMeta();
					meta.setCustomModelData(1560002);
					player.getInventory().getChestplate().setItemMeta(meta);
					World world = (World) player.getWorld();
					world.playSound(player.getLocation(), Sound.ENTITY_PHANTOM_FLAP, 10, 1);
					player.setVelocity(player.getLocation().getDirection().multiply(2));
					getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							//player.setVelocity(player.getLocation().getDirection().multiply(0.5));
							
						}
						}, 10L);
					return;
			}
		}
	
}
@EventHandler
public void toggleGlideEvent(EntityToggleGlideEvent event) {
	Player player = (Player) event.getEntity();
	if (player.getInventory().getChestplate().getType() == Material.ELYTRA) {
		if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData()) {
		if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1560001 || player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1560002) {
			
			if (player.isGliding()) {
				//gliding end
				player.sendMessage("eee");
				if (player.isDead() == false) {
					getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (player.getInventory().getChestplate() != null) {
							ItemMeta meta = player.getInventory().getChestplate().getItemMeta();
				meta.setCustomModelData(1560001);
				player.getInventory().getChestplate().setItemMeta(meta);
						}
						
				
					}
					}, 10L);
				}
				
				
			} else {
				//gliding start
				player.sendMessage("aaa");
				
				//player.setVelocity(player.getLocation().getDirection().multiply(1.1));
				
				//Vector vector = player.getLocation().getDirection();
				//player.setVelocity(new Vector
				//		(vector.getX() * 0.5,
				//		vector.getY() * 10,
				//		vector.getZ() * 0.5));
				
				player.setVelocity(new Vector(0, 1, 0));
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						//player.setVelocity(player.getLocation().getDirection().multiply(0.5));
						
					}
					}, 5L);
			}
			
			}
	}
		}
	
	}
	

@EventHandler()
public void onDamage(EntityDamageEvent event) {
	if (event.getEntity().getType().equals(EntityType.PLAYER)) {
		Player player = (Player) event.getEntity();
		
		if (player.isDead()) {
			return;
		}
		if (player.getInventory().getChestplate() != null)
	if (player.getInventory().getChestplate().getItemMeta() != null)
	if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true)
	if (player.getInventory().getChestplate().getItemMeta().hasLore())
		if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1560001 || player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1560002) {
		     double dmg = event.getDamage();
		     int num = (int) dmg;
		     String string = String.valueOf(num);
		     player.sendMessage(string);
			event.setDamage(dmg*0.5);
			if (event.getCause() == DamageCause.FALL && player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1560002) {
				Location loc = player.getLocation();
				if (player.isDead()) {
					return;
				}
				player.sendMessage("www");
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 2));
				
				//for (int i = 1; i < 4; i++) {
					//AreaEffectCloud aec = (AreaEffectCloud) ((World) loc).spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
					//PotionEffect pe = new PotionEffect(PotionEffectType.HARM, 1, 0, true, true);
					//aec.addCustomEffect(pe, true);
				player.setVelocity(new Vector(0, 0.5, 0));
					loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 2, false, false);
					
					loc.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
				//	loc.setX(loc.getX() + i);
				//}
			}
		}
	}
	
	
}
public ShapedRecipe geteaeaRecipe() {
	
	//test

	ItemStack item = new ItemStack(Material.ACACIA_BOAT);
	ItemMeta meta = item.getItemMeta();
	
	
	meta.setDisplayName(ChatColor.GOLD + "aaa ingot");
	meta.setCustomModelData(3330001);
	meta.addEnchant(Enchantment.MENDING, 43, true);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "aaaingot");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);

	recipe.shape("LLL", "LBe", "LLL");
	
	recipe.setIngredient('B', Material.ACACIA_BOAT);
	recipe.setIngredient('L', Material.IRON_INGOT);
	recipe.setIngredient('e', Material.BEDROCK);

	return recipe;
}

public ShapedRecipe gettestt() {
	ItemStack item = new ItemStack(Material.IRON_SWORD);
	ItemMeta meta = item.getItemMeta();
	meta.setDisplayName(ChatColor.GOLD + "aaa sword");
	item.setItemMeta(meta);
	
	ItemStack item2 = new ItemStack(Material.ACACIA_BOAT);
	ItemMeta meta2 = item.getItemMeta();
	meta2.setDisplayName(ChatColor.GOLD + "aaa ingot");
	meta2.setCustomModelData(3330001);
	meta2.addEnchant(Enchantment.MENDING, 43, true);
	item2.setItemMeta(meta2);
	
	@SuppressWarnings("deprecation")
	RecipeChoice custom1Choice = new RecipeChoice.ExactChoice(item2);
	NamespacedKey key = new NamespacedKey(this, "eeaaeeeaea");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item); //custom item that will be crafted
	recipe.shape(" H ", " H ", " I ");
	recipe.setIngredient('I', Material.BEDROCK);
	recipe.setIngredient('H', custom1Choice); // usage of the RecipeChoice
	return recipe;
}
//unused item
public ShapedRecipe getbonekatRecipe() {
	
	//bone
	
	ItemStack item = new ItemStack(Material.IRON_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Cutting Edge"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- +60% damage to players without a chestplate"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Two Handed"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- +50% damage if there is no item in offhand"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Critical Hit"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- 20% chance to deal 50% more damage when two handed"));

	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 4 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1.8 Attack Speed"));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.2, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
	
	meta.setDisplayName("Bone Katana");
	meta.setCustomModelData(4000002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "bone_katana");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("  M", " M ", "S  ");
	
	recipe.setIngredient('M', Material.BONE);
	recipe.setIngredient('S', Material.BEDROCK);
	
	return recipe;
}
public ShapedRecipe getOPSWORDRecipe() {
	
	//ggggg
	ItemStack item = new ItemStack(Material.NETHERITE_HOE);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6ULTIMATE SWORD"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click to kill everything"));

	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 69696969 Attack Damage"));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

	meta.setLore(lore);
	
	

	meta.setDisplayName("Really Really Good Sword");
	meta.setCustomModelData(1234567);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "fghtthnhtyhytrhrytrd");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("LLL", "fef", "fsf");
	recipe.setIngredient('L', Material.LAPIS_BLOCK);
	recipe.setIngredient('e', Material.GOLD_BLOCK);
	recipe.setIngredient('s', Material.DIAMOND_BLOCK);
	recipe.setIngredient('f', Material.REDSTONE);

	
	return recipe;
}
public ShapedRecipe getrepcrossRecipe() {
	
	//repeater crossbow
	
	ItemStack item = new ItemStack(Material.CROSSBOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Redstone Powered"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Hold redstone dust in offhand"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Fires 4 more arrows after the first arrow"));


	lore.add("");

	meta.setLore(lore);
	
	

	meta.setDisplayName("Repeating Crossbow");
	meta.setCustomModelData(5552001);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "repeater_crossbow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("SIS", "sRs", "rSr");
	
	recipe.setIngredient('I', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	recipe.setIngredient('r', Material.REDSTONE);
	recipe.setIngredient('s', Material.STRING);
	recipe.setIngredient('R', Material.REPEATER);
	
	return recipe;
}
public ShapedRecipe getburscrossRecipe() {
	
	//burst crossbow
	
	ItemStack item = new ItemStack(Material.CROSSBOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Redstone Powered"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Hold redstone dust in offhand"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Fires an additional arrow above and below"));


	lore.add("");

	meta.setLore(lore);
	
	

	meta.setDisplayName("Burst Crossbow");
	meta.setCustomModelData(5552002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "burst_crossbow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("SIS", "sRs", "rSr");
	
	recipe.setIngredient('I', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	recipe.setIngredient('r', Material.REDSTONE);
	recipe.setIngredient('s', Material.STRING);
	recipe.setIngredient('R', Material.COMPARATOR);
	
	return recipe;
}
public ShapedRecipe getRedstoneBowRecipe() {
	
	//redstone bow
	
	ItemStack item = new ItemStack(Material.BOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Redstone Powered"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Hold redstone dust in offhand"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Increases arrow speed and makes arrow piercing"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Also decreases arrow damage"));


	lore.add("");

	meta.setLore(lore);
	
	

	meta.setDisplayName("Redstone Bow");
	meta.setCustomModelData(3330005);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "redstone_bow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("rIs", "SRs", "rIs");
	
	recipe.setIngredient('I', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	recipe.setIngredient('r', Material.REDSTONE);
	recipe.setIngredient('s', Material.STRING);
	recipe.setIngredient('R', Material.COMPARATOR);
	
	return recipe;
}
@EventHandler
public void playerCrossBowShoot(EntityShootBowEvent event) {
	Entity entity = event.getEntity();
	//Float speed = event.getForce();
	//Entity arrow = event.getProjectile();
	if (entity.getType().equals(EntityType.PLAYER) ) {
		Player player = (Player) entity;
		//if (player.getInventory().getItemInOffHand().getType() == Material.BOW || player.getInventory().getItemInOffHand().getType() == Material.CROSSBOW) {
		//	return;
		//}
		
		
		//Vector playerDirection = player.getLocation().getDirection();
		//Arrow arrow = (Arrow) event.getProjectile();
		
		
		//Float speed = event.getForce();
		//arrow.setVelocity(new Vector
		//		(playerDirection.getX() * speed * 100,
		//		playerDirection.getY() * speed * 100,
		//		playerDirection.getZ()* speed * 100));
		//arrow.setDamage(arrow.getDamage()*0.05);
		//^^^that works to make damage less
		if (player.getInventory().getItemInMainHand() == null) {
			return;
		}
		if (player.getInventory().getItemInMainHand().hasItemMeta() == false) {
			return;
		}
		//repeating crossbow
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			if (player.getInventory().getChestplate() != null)
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552001 && player.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE) {
				if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() != true) {
				
					if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552001 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
						if (player.getInventory().getChestplate() != null) {
							if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
								if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
								if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
									
									return;
								}
								}
							}
							}
						player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								Vector playerDirection = player.getLocation().getDirection();
								Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
								arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
								
								Float speed = event.getForce();
								arrow.setVelocity(new Vector
										(playerDirection.getX() * speed * 4.5,
										playerDirection.getY() * speed * 5,
										playerDirection.getZ()* speed * 4.5));
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 3L); 
						
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								Vector playerDirection = player.getLocation().getDirection();
								Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
								arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
								Float speed = event.getForce();
								arrow.setVelocity(new Vector
										(playerDirection.getX() * speed * 4.5,
										playerDirection.getY() * speed * 5,
										playerDirection.getZ()* speed * 4.5));
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 6L);
						
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								Vector playerDirection = player.getLocation().getDirection();
								Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
								arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
								Float speed = event.getForce();
								arrow.setVelocity(new Vector
										(playerDirection.getX() * speed * 4.5,
										playerDirection.getY() * speed * 5,
										playerDirection.getZ()* speed * 4.5));
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 9L);
						
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {

								Vector playerDirection = player.getLocation().getDirection();
								Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
								arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
								Float speed = event.getForce();
								arrow.setVelocity(new Vector
										(playerDirection.getX() * speed * 4.5,
										playerDirection.getY() * speed * 5,
										playerDirection.getZ()* speed * 4.5));
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 12L);
					}
					return;
				}
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
						if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() != 1231234) {
							
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552001 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
								if (player.getInventory().getChestplate() != null) {
									if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
										if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
										if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
										
											return;
										}
										}
									}
									}
								player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										Vector playerDirection = player.getLocation().getDirection();
										Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
										arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
										
										Float speed = event.getForce();
										arrow.setVelocity(new Vector
												(playerDirection.getX() * speed * 4.5,
												playerDirection.getY() * speed * 5,
												playerDirection.getZ()* speed * 4.5));
										World world = player.getWorld();
										world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
										}
									}, 3L); 
								
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										Vector playerDirection = player.getLocation().getDirection();
										Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
										arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
										Float speed = event.getForce();
										arrow.setVelocity(new Vector
												(playerDirection.getX() * speed * 4.5,
												playerDirection.getY() * speed * 5,
												playerDirection.getZ()* speed * 4.5));
										World world = player.getWorld();
										world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
										}
									}, 6L);
								
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										Vector playerDirection = player.getLocation().getDirection();
										Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
										arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
										Float speed = event.getForce();
										arrow.setVelocity(new Vector
												(playerDirection.getX() * speed * 4.5,
												playerDirection.getY() * speed * 5,
												playerDirection.getZ()* speed * 4.5));
										World world = player.getWorld();
										world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
										}
									}, 9L);
								
								getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {

										Vector playerDirection = player.getLocation().getDirection();
										Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
										arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
										Float speed = event.getForce();
										arrow.setVelocity(new Vector
												(playerDirection.getX() * speed * 4.5,
												playerDirection.getY() * speed * 5,
												playerDirection.getZ()* speed * 4.5));
										World world = player.getWorld();
										world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
										}
									}, 12L);
							}
							return;
						}
						}
					
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 3L); 
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 6L);
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 9L);
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {

						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 12L);
			}
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552001 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
				if (player.getInventory().getChestplate() != null) {
					if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
						if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
							
							return;
						}
						}
					}
					}
				player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 3L); 
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 6L);
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 9L);
				
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {

						Vector playerDirection = player.getLocation().getDirection();
						Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
						arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						Float speed = event.getForce();
						arrow.setVelocity(new Vector
								(playerDirection.getX() * speed * 4.5,
								playerDirection.getY() * speed * 5,
								playerDirection.getZ()* speed * 4.5));
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
						}
					}, 12L);
			}
		}
		
		//burst crossbow
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			if (player.getInventory().getChestplate() != null) 
				
			
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552002 && player.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE) {
				Location loc = player.getLocation();
		        
				if (player.getInventory().getChestplate() != null) {
					if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() != true) {
							
							
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552002 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
								if (player.getInventory().getChestplate() != null) {
									if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
										if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
										if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
											
											return;
										}
										}
									}
									}
								player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
								
								
							        
							        //up down
							        double arrowAngle = 80;
							        double arrowAngle2 = 100; //90 is forward(i think) 80 is 10 above, 100 is 10 below
							       double totalAngle1 = loc.getPitch() + arrowAngle;
							       double totalAngle2 = loc.getPitch() + arrowAngle2;
							        double arrowDirY1 = Math.cos(Math.toRadians(totalAngle1));
							        double arrowDirY2 = Math.cos(Math.toRadians(totalAngle2));
							        Vector arrowDir1 = new Vector(loc.getDirection().getX()*5, arrowDirY1*5, loc.getDirection().getZ()*5);
							        Vector arrowDir2 = new Vector(loc.getDirection().getX()*5, arrowDirY2*5, loc.getDirection().getZ()*5);
							        Arrow arrow1 = player.launchProjectile(Arrow.class, arrowDir1);
							        arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
							        Arrow arrow2 = player.launchProjectile(Arrow.class, arrowDir2);
							        arrow2.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
							       
										//sounds
										getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
											public void run() {
												World world = player.getWorld();
												world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
												}
											}, 2L);
										getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
											public void run() {
												World world = player.getWorld();
												world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
												}
											}, 4L);
										
							}
							return;
						}
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
						if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() != 1231234) {
							
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552002 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
								if (player.getInventory().getChestplate() != null) {
									if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
										if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
										if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
											
											return;
										}
										}
									}
									}
								player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
								
							        
							        //up down
							        double arrowAngle = 80;
							        double arrowAngle2 = 100; //90 is forward(i think) 80 is 10 above, 100 is 10 below
							       double totalAngle1 = loc.getPitch() + arrowAngle;
							       double totalAngle2 = loc.getPitch() + arrowAngle2;
							        double arrowDirY1 = Math.cos(Math.toRadians(totalAngle1));
							        double arrowDirY2 = Math.cos(Math.toRadians(totalAngle2));
							        Vector arrowDir1 = new Vector(loc.getDirection().getX()*5, arrowDirY1*5, loc.getDirection().getZ()*5);
							        Vector arrowDir2 = new Vector(loc.getDirection().getX()*5, arrowDirY2*5, loc.getDirection().getZ()*5);
							        Arrow arrow1 = player.launchProjectile(Arrow.class, arrowDir1);
							        arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
							        Arrow arrow2 = player.launchProjectile(Arrow.class, arrowDir2);
							        arrow2.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
							       
										//sounds
										getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
											public void run() {
												World world = player.getWorld();
												world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
												}
											}, 2L);
										getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
											public void run() {
												World world = player.getWorld();
												world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
												}
											}, 4L);
										
							}
							return;
						}
						}
					}
					}
			        //up down
			        double arrowAngle = 80;
			        double arrowAngle2 = 100; //90 is forward(i think) 80 is 10 above, 100 is 10 below
			       double totalAngle1 = loc.getPitch() + arrowAngle;
			       double totalAngle2 = loc.getPitch() + arrowAngle2;
			        double arrowDirY1 = Math.cos(Math.toRadians(totalAngle1));
			        double arrowDirY2 = Math.cos(Math.toRadians(totalAngle2));
			        Vector arrowDir1 = new Vector(loc.getDirection().getX()*5, arrowDirY1*5, loc.getDirection().getZ()*5);
			        Vector arrowDir2 = new Vector(loc.getDirection().getX()*5, arrowDirY2*5, loc.getDirection().getZ()*5);
			        Arrow arrow1 = player.launchProjectile(Arrow.class, arrowDir1);
			        
			        arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
			        Arrow arrow2 = player.launchProjectile(Arrow.class, arrowDir2);
			        arrow2.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
			       
						//sounds
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 2L);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 4L);
			}
			
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 5552002 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
				if (player.getInventory().getChestplate() != null) {
					if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
						if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
							
							return;
						}
						}
					}
					}
				player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
				
				//arrow 1
				//		Vector playerDirection1 = player.getLocation().getDirection();
				//		Arrow arrow1 = player.launchProjectile(Arrow.class, playerDirection1);
				//		arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
						
				//		Float speed1 = event.getForce();
				//		arrow1.setVelocity(new Vector
				//				(playerDirection1.getX() * speed1 * 4.5,
				//				playerDirection1.getY() * speed1 * 6,
				//				playerDirection1.getZ()* speed1 * 4.5));
						
											
				//arrow 2		
				
				//		Vector playerDirection2 = player.getLocation().getDirection();
				//		Arrow arrow2 = player.launchProjectile(Arrow.class, playerDirection2);
				//		arrow2.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
				////		Float speed2 = event.getForce();
				//		arrow2.setVelocity(new Vector
				//				(playerDirection2.getX() * speed2 * 4.5,
				//				playerDirection2.getY() * speed2 * 4,
				//				playerDirection2.getZ()* speed2 * 4.5));
				 
			        Location loc = player.getLocation();
			        
			       //left right
			      //  double arrowAngle = 45;
			     //   double totalAngle = loc.getYaw() + arrowAngle;
			      //  double arrowDirX = Math.cos(Math.toRadians(totalAngle));
			      //  double arrowDirZ = Math.sin(Math.toRadians(totalAngle));
			       // Vector arrowDir = new Vector(arrowDirX, loc.getDirection().getY(), arrowDirZ);
			        
			        //up down
			        double arrowAngle = 80;
			        double arrowAngle2 = 100; //90 is forward(i think) 80 is 10 above, 100 is 10 below
			       double totalAngle1 = loc.getPitch() + arrowAngle;
			       double totalAngle2 = loc.getPitch() + arrowAngle2;
			        double arrowDirY1 = Math.cos(Math.toRadians(totalAngle1));
			        double arrowDirY2 = Math.cos(Math.toRadians(totalAngle2));
			        Vector arrowDir1 = new Vector(loc.getDirection().getX()*5, arrowDirY1*5, loc.getDirection().getZ()*5);
			        Vector arrowDir2 = new Vector(loc.getDirection().getX()*5, arrowDirY2*5, loc.getDirection().getZ()*5);
			        Arrow arrow1 = player.launchProjectile(Arrow.class, arrowDir1);
			        arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
			        Arrow arrow2 = player.launchProjectile(Arrow.class, arrowDir2);
			        arrow2.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
			       
						//sounds
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 2L);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								World world = player.getWorld();
								world.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 10, 1);
								}
							}, 4L);
						
			}
		}
		
		//redstone bow
		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
			if (player.getInventory().getChestplate() != null) 
				
			
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330005 && player.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE) {
				//Location loc = player.getLocation();
		        
				if (player.getInventory().getChestplate() != null) {
					if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() != true) {
							
							
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330005 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
								if (player.getInventory().getChestplate() != null) {
									if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
										if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
										if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
											
											return;
										}
										}
									}
									}
								player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
								
								
							        
							        //stuff
								Float speed = event.getForce();
								Arrow arrow = (Arrow) event.getProjectile();	
								Vector vector = player.getLocation().getDirection();
								
								arrow.setVelocity(new Vector
								(vector.getX() * speed * 10,
								vector.getY() * speed * 10,
								vector.getZ()* speed * 10));
							//	arrow.addPassenger(player);
								arrow.setPierceLevel(5);
								arrow.setDamage(arrow.getDamage()*0.2);
								
								return;
							}
							return;
						}
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
						if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() != 1231234) {
							
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330005 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
								if (player.getInventory().getChestplate() != null) {
									if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
										if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
										if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
											
											return;
										}
										}
									}
									}
								player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
								
							        
							        //stuff
								Float speed = event.getForce();
								Arrow arrow = (Arrow) event.getProjectile();	
								Vector vector = player.getLocation().getDirection();
								
								arrow.setVelocity(new Vector
										(vector.getX() * speed * 10,
										vector.getY() * speed * 10,
										vector.getZ()* speed * 10));
									//	arrow.addPassenger(player);
										arrow.setPierceLevel(5);
										arrow.setDamage(arrow.getDamage()*0.2);
								return;
							}
							return;
						}
						}
					}
					}

				//stuff
				Float speed = event.getForce();
				Arrow arrow = (Arrow) event.getProjectile();	
				Vector vector = player.getLocation().getDirection();
				
				arrow.setVelocity(new Vector
						(vector.getX() * speed * 10,
						vector.getY() * speed * 10,
						vector.getZ()* speed * 10));
					//	arrow.addPassenger(player);
						arrow.setPierceLevel(5);
						arrow.setDamage(arrow.getDamage()*0.2);
				return;
			}
			
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3330005 && player.getInventory().getItemInOffHand().getType() == Material.REDSTONE) {
				if (player.getInventory().getChestplate() != null) {
					if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
						if (player.getInventory().getChestplate().getItemMeta().hasCustomModelData() == true) {
						if (player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1231234) {
							
							return;
						}
						}
					}
					}
				player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
				
				//stuff
				Float speed = event.getForce();
				Arrow arrow = (Arrow) event.getProjectile();	
				Vector vector = player.getLocation().getDirection();
				
				arrow.setVelocity(new Vector
						(vector.getX() * speed * 10,
						vector.getY() * speed * 10,
						vector.getZ()* speed * 10));
					//	arrow.addPassenger(player);
						arrow.setPierceLevel(5);
						arrow.setDamage(arrow.getDamage()*0.2);	
				return;
						
			}
		}
	
	}
}

@EventHandler
public void playerKillEntity(EntityDeathEvent event) {
	Entity killed = event.getEntity();
	
//	if (event.getEntity().getKiller().getType() == EntityType.PLAYER) {
	//	Player player = (Player) event.getEntity().getKiller();
	//	if (player.getInventory().getItemInMainHand().getType().equals(Material.ACACIA_BOAT)) {
	//		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
				//if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 0) {
	//				ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
	//				meta.setCustomModelData(meta.getCustomModelData()+1);
	//				String string = String.valueOf(meta.getCustomModelData());
	//				List<String> lore = new ArrayList<String>();
	//				lore.add("");
	//				lore.add(ChatColor.translateAlternateColorCodes('&', "&6"+string));
	//				meta.setLore(lore);
	//				AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 0.1, 
	//						Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
	//				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
//					player.getInventory().getItemInMainHand().setItemMeta(meta);
				//}
	//		}
	//	}
	//}
	
	if (killed.getType() == EntityType.WITHER_SKELETON) {
		World world = killed.getWorld();
		ItemStack witherbone = new ItemStack(Material.BONE);
		ItemMeta meta = witherbone.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "Wither Bone");
		meta.setCustomModelData(2222222);
		witherbone.setItemMeta(meta);
		
		ItemStack vessel = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta vmeta = witherbone.getItemMeta();
		vmeta.setDisplayName(ChatColor.YELLOW + "Vessel");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Parry"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7  (1 second cooldown)"));
		vmeta.setLore(lore);
		vmeta.setCustomModelData(2222223);
		vessel.setItemMeta(vmeta);
		int random = getRandomInt(5);
		if (random == 1) {
			if (this.getConfig().getString("WitherBones") == "true") {
			world.dropItemNaturally(killed.getLocation(), witherbone);
			}
		}
		if (random == 2) {
			if (this.getConfig().getString("WitherBones") == "true") {
			world.dropItemNaturally(killed.getLocation(), witherbone);
			world.dropItemNaturally(killed.getLocation(), witherbone);
			}
		}
		int random2 = getRandomInt(100);
		if (random2 == 1) {
			if (this.getConfig().getString("Vessel") == "true") {
			world.dropItemNaturally(killed.getLocation(), vessel);
			}
		}
	}
	if (this.getConfig().getString("InfusedVessel") == "true") {
	if (killed.getType() == EntityType.WITHER) {
		if (event.getEntity().getKiller() != null) {
		if (event.getEntity().getKiller().getType() == EntityType.PLAYER) {
			Player player = (Player) event.getEntity().getKiller();
			if (player.getInventory().getItemInMainHand().hasItemMeta() != true) {
				return;
			} else {
			if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
				return;
			} else {
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222223) {
				World world = player.getWorld();
				world.spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ(), 500);
				world.spawnParticle(Particle.CLOUD, player.getLocation(), 100);
				ItemMeta meta2 = player.getInventory().getItemInMainHand().getItemMeta();
				meta2.setCustomModelData(2222224);
				meta2.setDisplayName(ChatColor.YELLOW + "Infused Vessel");
					AttributeModifier modifier1a = new AttributeModifier(UUID.randomUUID(), "Damage", 9, 
							Operation.ADD_NUMBER, EquipmentSlot.HAND);
					meta2.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1a);
					AttributeModifier modifier2a = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -2.4, 
							Operation.ADD_NUMBER, EquipmentSlot.HAND);
					meta2.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2a);
					
					List<String> lore2 = new ArrayList<String>();
					lore2.add("");
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&6Wither's Evil"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&7- Inflicts wither"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&7  on opponents"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&6Parry"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&7  (1 second cooldown)"));
					lore2.add("");
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&9 10 Attack Damage"));
					lore2.add(ChatColor.translateAlternateColorCodes('&', "&9 1.6 Attack Speed"));
					meta2.setLore(lore2);
					//important:
					meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
					player.getInventory().getItemInMainHand().setItemMeta(meta2);
			}
			}
			}
		}
			
		}
	}
	}
	if (this.getConfig().getString("CursedVessel") == "true") {
	if (killed.getType() == EntityType.ENDER_DRAGON) {
		if (event.getEntity().getKiller() != null) {
		if (event.getEntity().getKiller().getType() == EntityType.PLAYER) {
			Player player = (Player) event.getEntity().getKiller();
			if (player.getInventory().getItemInMainHand().hasItemMeta() != true) {
				return;
			} else {
			if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
				return;
			} else {
			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222223) {
				World world = player.getWorld();
				world.spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ(), 500);
				world.spawnParticle(Particle.CLOUD, player.getLocation(), 100);
				ItemMeta meta3 = player.getInventory().getItemInMainHand().getItemMeta();
				meta3.setCustomModelData(2222225);
				meta3.setDisplayName(ChatColor.YELLOW + "Cursed Vessel");
					AttributeModifier modifier1e = new AttributeModifier(UUID.randomUUID(), "Damage", 9, 
							Operation.ADD_NUMBER, EquipmentSlot.HAND);
					meta3.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1e);
					AttributeModifier modifier2e = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -2.4, 
							Operation.ADD_NUMBER, EquipmentSlot.HAND);
					meta3.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2e);
					//AttributeModifier modifier3e = new AttributeModifier(UUID.randomUUID(), "Health", -0.5, 
					//		Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
					//meta3.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier3e);
					
					List<String> lore3 = new ArrayList<String>();
					lore3.add("");
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&6Dragon's Curse"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&7- +50% damage dealt"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&7  +50% damage taken"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&6Parry"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&7  (1 second cooldown)"));
					lore3.add("");
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&9 10 Attack Damage"));
					lore3.add(ChatColor.translateAlternateColorCodes('&', "&9 1.6 Attack Speed"));
					meta3.setLore(lore3);
					//important:
					meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
					player.getInventory().getItemInMainHand().setItemMeta(meta3);
			}
		}
			}
		}
		}
	}
	}
	if (event.getEntity().getKiller() != null) {
	if (event.getEntity().getKiller().getType() == EntityType.PLAYER) {
		Player player = (Player) event.getEntity().getKiller();
		if (player.getInventory().getItemInOffHand().getType().equals(Material.NETHER_STAR))
			if (player.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData())
				if (player.getInventory().getItemInOffHand().getItemMeta().hasLore()) {
					
					if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 4920001) {
						
						World world = player.getWorld();
						ExperienceOrb orb = world.spawn(player.getLocation(), ExperienceOrb.class);
						orb.setExperience(orb.getExperience()+getRandomInt(10)+10);
					//	orb.setExperience(100);
					//	player.sendMessage(String.valueOf(orb.getExperience()));
					}
				}
	} 
}
}


public ShapedRecipe getDiaShieldRecipe() {
	
	//ggggg
	ItemStack item = new ItemStack(Material.SHIELD);
	ItemMeta meta = item.getItemMeta();
	if (this.getConfig().getString("EnchantsDiamondShield") == "true") {
		int num = this.getConfig().getInt("DShieldEnchantLevels.Unbreaking");
		
		meta.addEnchant(Enchantment.DURABILITY, num, true);

	}
	
	meta.setDisplayName("Diamond Shield");
	meta.setCustomModelData(5430001);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "ddddeewerewsdtgew");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("LeL", "LLL", " L ");
	recipe.setIngredient('L', Material.IRON_INGOT);
	recipe.setIngredient('e', Material.DIAMOND);

	
	return recipe;
}
public ShapedRecipe getNethShieldRecipe() {
	
	//ggggg
	ItemStack item = new ItemStack(Material.SHIELD);
	ItemMeta meta = item.getItemMeta();
	if (this.getConfig().getString("EnchantsNetheriteShield") == "true") {
		int num = this.getConfig().getInt("NShieldEnchantLevels.Unbreaking");
		
		meta.addEnchant(Enchantment.DURABILITY, num, true);

	}
	meta.setDisplayName("Netherite Shield");
	meta.setCustomModelData(5430002);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "aaaasdtgddew");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("LeL", "LLL", " L ");
	recipe.setIngredient('L', Material.IRON_INGOT);
	recipe.setIngredient('e', Material.NETHERITE_INGOT);

	
	return recipe;
}


@EventHandler()
public void onParryClick(PlayerInteractEvent event) {
	if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_SWORD))
		if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
		if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			Player player = (Player) event.getPlayer();
			
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				//vessel
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222223) {
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222223);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222223) {
											meta.setCustomModelData(2222223);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
				//infvessel
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222224) {
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222224);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222224) {
											meta.setCustomModelData(2222224);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
				//cursvessel
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222225) {
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222225);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222225) {
											meta.setCustomModelData(2222225);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
				//awak ves
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222226) {
					if (player.isSneaking()) {
						return;
					}
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222226);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222226) {
											meta.setCustomModelData(2222226);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222227) {
					if (player.isSneaking()) {
						return;
					}
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222227);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222227) {
											meta.setCustomModelData(2222227);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222228) {
					if (player.isSneaking()) {
						return;
					}
					
					
					if (Cooldown.checkCooldown(event.getPlayer())) {
						
						
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222228);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222228) {
											meta.setCustomModelData(2222228);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222229) {
					if (player.isSneaking()) {
						return;
					}
					if (Cooldown.checkCooldown(event.getPlayer())) {
						player.setCooldown(Material.NETHERITE_SWORD, 20);
						World world = player.getWorld();
						world.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, 10, 1);
						ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
						
						meta.setCustomModelData(1222229);
						player.getInventory().getItemInMainHand().setItemMeta(meta);
						getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							public void run() {
								if (player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
									if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
										if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1222229) {
											meta.setCustomModelData(2222229);
								player.getInventory().getItemInMainHand().setItemMeta(meta);
										}
									}
								}
								
								}
							}, 10L); 
						Cooldown.setCooldown(event.getPlayer(), 1);
						
					} else {
						return;
						
					}	
				
				}
			}
		}
	
}

@EventHandler
void onSmithingTableEventAWAKVES2(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.NETHERITE_SWORD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() != true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }
  if(tool.getItemMeta().getCustomModelData() != 2222225 || modifier.getItemMeta().getCustomModelData() != 2222224) {
	    return;
	  }
  ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
	ItemMeta meta = item.getItemMeta();
	meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Awakened Vessel");
	meta.setCustomModelData(2222228);
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 11, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -2.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Evocation"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Summons fangs to attack"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  all mobs within a 5 block"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  radius, dealing 6 damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  Shift + Right click to toggle"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- (Activates on a"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  fully charged attack)"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Uses up 1 xp level each use"));

	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Parry"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  (1 second cooldown)"));
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 12 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1.4 Attack Speed"));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	item.setItemMeta(meta);
  
if (this.getConfig().getString("AwakenedVesselPurple") == "true") {
	  event.setResult(item);
}

}
@EventHandler
void onSmithingTableEventAWAKVES(PrepareSmithingEvent event) {
  SmithingInventory inventory = event.getInventory();

  ItemStack tool = inventory.getItem(0);
  ItemStack modifier = inventory.getItem(1);

  if(tool == null || modifier == null) {
    return;
  }

  if(tool.getType() != Material.NETHERITE_SWORD || modifier.getType() != Material.NETHERITE_SWORD) {
    return;
  }
  
  if(tool.getItemMeta().hasCustomModelData() != true || modifier.getItemMeta().hasCustomModelData() != true) {
	    return;
	  }
  if(tool.getItemMeta().getCustomModelData() != 2222224 || modifier.getItemMeta().getCustomModelData() != 2222225) {
	    return;
	  }
  ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
	ItemMeta meta = item.getItemMeta();
	meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Awakened Vessel");
	meta.setCustomModelData(2222226);
	AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "Damage", 11, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Atackspeed", -2.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Magic Aura"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Inflicts 6 magic damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  on all mobs within"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  a 5 block radius"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  Shift + Right click to toggle"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- (Activates on a"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  fully charged attack)"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Uses up 1 xp level each use"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Parry"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Right click"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  (1 second cooldown)"));
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 12 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1.4 Attack Speed"));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	item.setItemMeta(meta);
  
if (this.getConfig().getString("AwakenedVesselWhite") == "true") {
	  event.setResult(item);
}

}
public SmithingRecipe getawakswordsrecipe() {
	//this is important or else other recipe no worky
	SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "tesfergvergtt"),
		      new ItemStack(Material.AIR), 
		      new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD),
	      new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD)
	     );
	    
	    return recipe;
}
@EventHandler()
public void onleftClick(PlayerInteractEvent event) {
	
	//if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	//  if (event.getHand().equals(EquipmentSlot.HAND)) {
	//	  Player player = (Player) event.getPlayer();
	//	  if (player.getInventory().getItemInOffHand() != null) {
	//		  if (player.getInventory().getItemInOffHand().hasItemMeta()) {
	//			  if (player.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData()) {
	//				  if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010) {
	//					  if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	//						  player.swingOffHand();
	//						  player.setCooldown(player.getInventory().getItemInOffHand().getType(), 12);
							  
	//					  }
	//				  }
	//			  }
	//		  }
	//	  }
	//  }
	//  }
	//if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR))
	//	if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
	//		if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
	//			Player player = (Player) event.getPlayer();
	//			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4920001) {
	//				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	//				World world = player.getWorld();
	//				ExperienceOrb orb = world.spawn(player.getLocation(), ExperienceOrb.class);
	//				orb.setExperience(1);
	//				}
	//			}
	//		}
	if (event.getPlayer().getInventory().getItemInMainHand() == null) {
		return;
	}
	if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() == false) {
		return;
	}
	if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_SWORD))
		if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
		if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
			Player player = (Player) event.getPlayer();
			
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
				//if (Cooldown.checkCooldown(event.getPlayer())) {
				if (player.getAttackCooldown() == 1.0) {
					
				
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222226 || 
						player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222228) {
				List<Entity> ee = player.getNearbyEntities(5, 5, 5);
						//if (player.getLevel() > ee.size()) {
				if (player.getLevel() > 1) {
						
						player.setLevel(player.getLevel()-1);
				
					
					for (int e=0;e<ee.size();e++) {
						Entity entity = ee.get(e);
						
						
						if (entity instanceof LivingEntity) {
							LivingEntity livingen = (LivingEntity) entity;
							
							if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222226) {
							if (livingen.getCategory().equals(EntityCategory.UNDEAD)) {
								livingen.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
							} else {
								if (entity instanceof Player != true) {
								livingen.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
								
								}
							}
						}
								World world = player.getWorld();
								if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222228) {
									world.spawnEntity(entity.getLocation(), EntityType.EVOKER_FANGS);
									//world.strikeLightning(entity.getLocation());
								}
								
										
				world.playSound(entity.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);

				world.spawnParticle(Particle.SWEEP_ATTACK, entity.getLocation().getX(), entity.getLocation().getY()+1, entity.getLocation().getZ(), 1);		
			
						
						}
					}
					
				}
				
						//}
					//player.setCooldown(Material.NETHERITE_SWORD, 20);
					//}
				
				//Cooldown.setCooldown(event.getPlayer(), 1);
				}
			}
			}
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (player.isSneaking()) {
				if (Cooldown.checkCooldown(event.getPlayer())) {
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222226) {
					ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
					meta.setCustomModelData(2222227);
					player.getInventory().getItemInMainHand().setItemMeta(meta);
					player.sendMessage(ChatColor.RED + "Magic Aura: DISABLED");
					Cooldown.setCooldown(event.getPlayer(), 1);
				}
				if (Cooldown.checkCooldown(event.getPlayer())) {
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222227) {
					ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
					meta.setCustomModelData(2222226);
					player.getInventory().getItemInMainHand().setItemMeta(meta);
					player.sendMessage(ChatColor.GREEN + "Magic Aura: ENABLED");
					Cooldown.setCooldown(event.getPlayer(), 1);
				}
				}
				}
			}
			}
			//another one
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (player.isSneaking()) {
				if (Cooldown.checkCooldown(event.getPlayer())) {
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222228) {
					ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
					meta.setCustomModelData(2222229);
					player.getInventory().getItemInMainHand().setItemMeta(meta);
					player.sendMessage(ChatColor.RED + "Evocation: DISABLED");
					Cooldown.setCooldown(event.getPlayer(), 1);
				}
				if (Cooldown.checkCooldown(event.getPlayer())) {
				if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2222229) {
					ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
					meta.setCustomModelData(2222228);
					player.getInventory().getItemInMainHand().setItemMeta(meta);
					player.sendMessage(ChatColor.GREEN + "Evocation: ENABLED");
					Cooldown.setCooldown(event.getPlayer(), 1);
				}
				}
				}
			}
			}
		}
	
}
public ShapedRecipe getERecipe() {
	
	//ggggg
	ItemStack item = new ItemStack(Material.NETHER_STAR);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Increases xp gained from mobs when held in offhand");
	lore.add("");
	meta.setLore(lore);
	
	

	
	

	meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Star Charm");
	meta.setCustomModelData(4920001);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "Aaaa");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape("LLL", "LeL", "LLL");
	recipe.setIngredient('L', Material.LAPIS_BLOCK);
	recipe.setIngredient('e', Material.NETHER_STAR);


	
	return recipe;
}
//DUAL WIELDING
@EventHandler
public void onRightClickEntity(PlayerInteractEntityEvent event) {
  Player player = event.getPlayer();
  if (event.getHand().equals(EquipmentSlot.HAND)) {
  if (player.getInventory().getItemInOffHand() != null) {
	  if (player.getInventory().getItemInOffHand().hasItemMeta()) {
		  if (player.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData()) {
			  if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010
						 || player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1200010
						 || player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000030) {
				  
				  //stops dual wielding 2 different weapon type:
				  if (this.getConfig().getString("DualWieldSaberOnly") == "true") {
					  //test the config thing, not sure if it works
				  if (player.getInventory().getItemInMainHand() != null) {
					  if (player.getInventory().getItemInMainHand().hasItemMeta()) {
						  if (player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SWORD)) {
							if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
							 if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000010
									 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1200010
									 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000030) {
								  return;
							 }
							  }
							if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
								return;
							}
						  }
						  if (player.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD)) {
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
								 if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1200010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000030) {
									  return;
								 }
								  }
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
									return;
								}
							  }
						  if (player.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_SWORD)) {
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
								 if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1200010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000030) {
									  return;
								 }
								  }
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
									return;
								}
							  }
						  if (player.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD)) {
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
								 if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1200010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000030) {
									  return;
								 }
								  }
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
									return;
								}
							  }
						  if (player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD)) {
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
								 if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1200010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000030) {
									  return;
								 }
								  }
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
									return;
								}
							  }
						  if (player.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_SWORD)) {
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
								 if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1200010
										 && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1000030) {
									  return;
								 }
								  }
								if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() != true) {
									return;
								}
							  }
					  }
				  }
				  }
		  player.swingOffHand();

if (event.getRightClicked() instanceof Damageable) {
	Damageable e = (Damageable) event.getRightClicked();
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.WOODEN_SWORD)) {
		double dmg = 4;
		double cooldown = player.getCooldown(Material.WOODEN_SWORD);
				
		if (player.hasCooldown(Material.WOODEN_SWORD)) {
			//12 is number of ticks left of the cooldown
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
		if (player.hasCooldown(Material.WOODEN_SWORD) == false) {
	e.damage(dmg, player);
	//.damage(amount, source of the damage (entity));
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.STONE_SWORD)) {
		double dmg = 5;
		double cooldown = player.getCooldown(Material.STONE_SWORD);
		if (player.hasCooldown(Material.STONE_SWORD)) {
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.STONE_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.IRON_SWORD)) {
		double dmg = 6;
		double cooldown = player.getCooldown(Material.IRON_SWORD);
		if (cooldown != 1) {
			if (cooldown <= 1
					&& cooldown > 0.8) {
				double dmg2 = dmg * 0.9;
				e.damage(dmg2, player);
			}
			if (cooldown <= 0.8
					&& cooldown > 0.6) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			}
			if (cooldown <= 0.6
					&& cooldown > 0.4) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 0.4
					&& cooldown > 0.2) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 0.2) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.IRON_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.GOLDEN_SWORD)) {
		double dmg = 4;
		double cooldown = player.getCooldown(Material.GOLDEN_SWORD);
		if (player.hasCooldown(Material.GOLDEN_SWORD)) {
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.GOLDEN_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000030 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.GOLDEN_SWORD)) {
		double dmg = 6;
		double cooldown = player.getCooldown(Material.GOLDEN_SWORD);
		if (player.hasCooldown(Material.GOLDEN_SWORD)) {
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.GOLDEN_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.DIAMOND_SWORD)) {
		double dmg = 7;
		double cooldown = player.getCooldown(Material.DIAMOND_SWORD);
		if (player.hasCooldown(Material.DIAMOND_SWORD)) {
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.DIAMOND_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1000010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.NETHERITE_SWORD)) {
		double dmg = 8;
		double cooldown = player.getCooldown(Material.NETHERITE_SWORD);
		if (player.hasCooldown(Material.NETHERITE_SWORD)) {
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.NETHERITE_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	if (player.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 1200010 
			&& player.getInventory().getItemInOffHand().getType().equals(Material.NETHERITE_SWORD)) {
		double dmg = 9;
		double cooldown = player.getCooldown(Material.NETHERITE_SWORD);
		if (player.hasCooldown(Material.NETHERITE_SWORD)) {
			if (cooldown <= 12 * 0.2) {
				double dmg2 = dmg * 0.8;
				e.damage(dmg2, player);
			} 
			if (cooldown <= 12 * 0.4
					&& cooldown > 12 * 0.2) {
				double dmg2 = dmg * 0.6;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.6
					&& cooldown > 12 * 0.4) {
				double dmg2 = dmg * 0.4;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12 * 0.8
					&& cooldown > 12 * 0.6) {
				double dmg2 = dmg * 0.2;
				e.damage(dmg2, player);
			}
			if (cooldown <= 12
					&& cooldown > 12 * 0.8) {
				double dmg2 = dmg * 0.1;
				e.damage(dmg2, player);
			}
		}
	if (player.hasCooldown(Material.NETHERITE_SWORD) == false) {
	e.damage(dmg, player);
	World world = player.getWorld();			
	world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);
	}
	}
	
	
				player.setCooldown(player.getInventory().getItemInOffHand().getType(), 12);
}
		  //i think this part below was the old way for saber dual wielding
 // Vector playerDirection = player.getLocation().getDirection();
//	Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
//	arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
//	arrow.setSilent(true);
	
//	arrow.setVelocity(new Vector
//			(playerDirection.getX() * 45,
//			playerDirection.getY() * 50,
//			playerDirection.getZ()* 45));
//	if (player.getInventory().getItemInMainHand().hasItemMeta()) {
//		if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
//			if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000010
//					 || player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1200010) {
//				
//				if (player.hasCooldown(player.getInventory().getItemInOffHand().getType())) {
//					  int num = 12-player.getCooldown(player.getInventory().getItemInOffHand().getType());
//					  double dmg = num * 0.083;
//					  player.sendMessage(String.valueOf(dmg));
					  
//					  arrow.setDamage(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue()/100*dmg);
//				  } else {
//					  if (player.hasCooldown(player.getInventory().getItemInOffHand().getType()) != true) {
//						  arrow.setDamage(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue()/100);
//					  }
//				  }
				
				
//				World world = player.getWorld();			
//				world.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 10, 1);

//							player.setCooldown(player.getInventory().getItemInOffHand().getType(), 12);
//							return;
//			}
//		}
//	}
//	if (player.hasCooldown(player.getInventory().getItemInOffHand().getType())) {
//		int num = 12-player.getCooldown(player.getInventory().getItemInOffHand().getType());
//		  double dmg = num * 0.083;
//		  player.sendMessage(String.valueOf(dmg));
//		  arrow.setDamage(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue()/50*dmg);
//	  } else {
//		  if (player.hasCooldown(player.getInventory().getItemInOffHand().getType()) != true) {
//			  arrow.setDamage(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue()/50);
//		  }
//	  }
			  }
		  }
	  }
  }
}
}

public ShapedRecipe getWSaberRecipe() {
	
	//wood
	
	ItemStack item = new ItemStack(Material.WOODEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("WoodenSaber.name")));
	meta.setCustomModelData(1000010);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wooden_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
	recipe.shape(" SS", " S ", "S  ");
	
	
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getGSaberRecipe() {
	
	//gold
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 3, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("GoldSaber.name")));
	meta.setCustomModelData(1000010);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "golden_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" aa", " a ", "S  ");
	
	recipe.setIngredient('a', Material.GOLD_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getSSaberRecipe() {
	
	//stone
	
	ItemStack item = new ItemStack(Material.STONE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("StoneSaber.name")));
	meta.setCustomModelData(1000010);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "stone_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" aa", " a ", "S  ");
	
	recipe.setIngredient('a', Material.COBBLESTONE);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getISaberRecipe() {
	
	//iron
	
	ItemStack item = new ItemStack(Material.IRON_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("IronSaber.name")));
	meta.setCustomModelData(1000010);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "iron_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" aa", " a ", "S  ");
	
	recipe.setIngredient('a', Material.IRON_INGOT);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getESaberRecipe() {
	
	//emerald
	
	ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("EmeraldSaber.name")));
	meta.setCustomModelData(1000030);
	if (this.getConfig().getString("EnchantsOnEmeraldGear") == "true") {
		int num = this.getConfig().getInt("EmeraldGearEnchantLevels.Unbreaking");
		int num2 = this.getConfig().getInt("EmeraldGearEnchantLevels.Mending");
		meta.addEnchant(Enchantment.DURABILITY, num, true);
	meta.addEnchant(Enchantment.MENDING, num2, true);
	}
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "emerald_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" aa", " a ", "S  ");
	
	recipe.setIngredient('a', Material.EMERALD);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getDSaberRecipe() {
	
	//diamond
	
	ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("DiamondSaber.name")));
	meta.setCustomModelData(1000010);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "diamond_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" aa", " a ", "S  ");
	
	recipe.setIngredient('a', Material.DIAMOND);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}

public ShapedRecipe getNSaberRecipe() {
	
	//netherite
	
	ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line1")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line2")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line3")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line4")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line5")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line6")));
	lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.line7")));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.4, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Damage", 7, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);

	
	meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("NetheriteSaber.name")));
	meta.setCustomModelData(1000010);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "netherite_saber");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" aa", " a ", "S  ");
	
	recipe.setIngredient('a', Material.NETHERITE_SCRAP);
	recipe.setIngredient('S', Material.STICK);
	
	return recipe;
}
public ShapedRecipe getRedPlateRecipe() {
	
	
	
	ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Power Source"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- While wearing this, redstone powered"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  weapons will no longer require"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  holding redstone in the offhand"));
	meta.setLore(lore);
meta.setUnbreakable(true);
meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Armor", 2, 
			Operation.ADD_NUMBER, EquipmentSlot.CHEST);
	meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
	
	meta.setDisplayName("Redstone Core");
	meta.setCustomModelData(1231234);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "redstone_core");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape("ede", "dcd", "bab");
	
	recipe.setIngredient('a', Material.IRON_CHESTPLATE);
	recipe.setIngredient('b', Material.LEATHER);
	recipe.setIngredient('c', Material.REDSTONE_BLOCK);
	recipe.setIngredient('d', Material.COMPARATOR);
	recipe.setIngredient('e', Material.QUARTZ);
	
	return recipe;
}
public ShapedRecipe getLsBowRecipe() {
	
	//longsword bow
	
	ItemStack item = new ItemStack(Material.BOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");

	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Strong Shot"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Slightly increased arrow velocity"));
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7When in Main Hand:"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 8 Attack Damage"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&9 1.4 Attack Speed"));
	meta.setLore(lore);
	//important:
	meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

	//modifier
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Damage", 7, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "Attack Speed", -2.6, 
			Operation.ADD_NUMBER, EquipmentSlot.HAND);
	meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
	
	
	meta.setDisplayName("Longsword Bow");
	meta.setCustomModelData(3330004);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "longsword_bow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" b ", " b ", "bab");
	
	recipe.setIngredient('a', Material.BOW);
	recipe.setIngredient('b', Material.IRON_INGOT);
//	recipe.setIngredient('c', Material.IRON_BLOCK);
	
	return recipe;
}
public ShapedRecipe getTridentBowRecipe() {
	
	//trident bow
	
	ItemStack item = new ItemStack(Material.BOW);
	ItemMeta meta = item.getItemMeta();
	
	List<String> lore = new ArrayList<String>();
	lore.add("");

	lore.add(ChatColor.translateAlternateColorCodes('&', "&6I made this for fun"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Shoots tridents (converts arrows to tridents)"));
	lore.add("");
	meta.setLore(lore);
	
	
	meta.setDisplayName("Trident Bow");
	meta.setCustomModelData(1069691);
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "trident_bow");
	keys.add(key);
	ShapedRecipe recipe = new ShapedRecipe(key, item);
	
recipe.shape(" b ", "bab", " b ");
	
	recipe.setIngredient('a', Material.TRIDENT);
	recipe.setIngredient('b', Material.BEDROCK);
//	recipe.setIngredient('c', Material.IRON_BLOCK);
	
	return recipe;
}

// test for spawning custom particle
// spawns armor stand with item with custom texture
// doesn't really work because the armor stand is sometimes visible for a split second before becoming invis
//@SuppressWarnings("deprecation")
//@EventHandler
//public void onRightClickEntity2(PlayerInteractEntityEvent event) {
//	Player player = event.getPlayer();
	
//	if (player.getInventory().getItemInMainHand().getType() != Material.GOLDEN_SHOVEL) {
//		return;
//	}
//		if (event.getRightClicked() instanceof Damageable) {
//			Damageable ent = (Damageable) event.getRightClicked();
//			ent.damage(10, player);
			
//			 Vector direc = player.getLocation().getDirection().multiply(2);
//	            Location loc = player.getLocation().add(direc);
//	            Location loca = new Location(player.getWorld(), loc.getX(), loc.getY() + 10, loc.getZ());
//	            ArmorStand stand = (ArmorStand) player.getLocation().getWorld().spawnEntity(loca, EntityType.ARMOR_STAND);
//	            stand.setVisible(false);
//	            stand.setInvulnerable(true);
//	            stand.setGravity(false);
	            
//	            ItemStack item = new ItemStack(Material.POTATO);
//	            ItemMeta meta = item.getItemMeta();
//	            meta.setCustomModelData(9873221);
//	            item.setItemMeta(meta);
	            
//	            stand.setHelmet(item);
//	            stand.addEquipmentLock(EquipmentSlot.HEAD, LockType.REMOVING_OR_CHANGING);
//	            Bukkit.getScheduler().runTaskLater(this, () -> {
	            	
//	                stand.remove();
//	            }, 10); // Time in ticks (20 ticks = 1 second)
	            
//		}
	
//}


//test
public ShapedRecipe getWitherHelmetRecipe() {
	
	//wither bone helmet

	ItemStack item = new ItemStack(Material.IRON_HELMET);
	ItemMeta meta = item.getItemMeta();
	
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.HEAD);
	meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "KnockbackResistance", 0.2, 
			Operation.ADD_NUMBER, EquipmentSlot.HEAD);
	meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier2);
	
	meta.setDisplayName(ChatColor.YELLOW + "Withering Helmet");
	meta.setCustomModelData(5553331);
	
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Full Set Bonus"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Fully charged melee attacks"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  heal 50% of the damage dealt"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- When damage is taken, "));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  get Wither III for 3 seconds"));
	lore.add("");
	
	meta.setLore(lore);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wither_bone_helmet");
	keys.add(key);
	
	ItemStack wbone = new ItemStack(Material.BONE);
	ItemMeta meta2 = wbone.getItemMeta();
	meta2.setDisplayName(ChatColor.YELLOW + "Wither Bone");
	meta2.setCustomModelData(2222222);
	wbone.setItemMeta(meta2);
	
	@SuppressWarnings("deprecation")
	RecipeChoice wibone = new RecipeChoice.ExactChoice(wbone);
	ShapedRecipe recipe = new ShapedRecipe(key, item); //custom item that will be crafted
	recipe.shape("BBB", "B B", " N ");
	//recipe.setIngredient('I', Material.BEDROCK);
	recipe.setIngredient('N', Material.NETHERITE_INGOT);
	recipe.setIngredient('B', wibone); // usage of the RecipeChoice
	return recipe;
}

public ShapedRecipe getWitherChestRecipe() {
	
	//wither bone chestplate

		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", 5, 
				Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "KnockbackResistance", 0.2, 
				Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier2);
		
		meta.setDisplayName(ChatColor.YELLOW + "Withering Chestplate");
		meta.setCustomModelData(5553332);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Full Set Bonus"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Fully charged melee attacks"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7  heal 50% of the damage dealt"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7- When damage is taken, "));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7  get Wither III for 3 seconds"));
		lore.add("");
		
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "wither_bone_chestplate");
		keys.add(key);
		
		ItemStack wbone = new ItemStack(Material.BONE);
		ItemMeta meta2 = wbone.getItemMeta();
		meta2.setDisplayName(ChatColor.YELLOW + "Wither Bone");
		meta2.setCustomModelData(2222222);
		wbone.setItemMeta(meta2);
		
		@SuppressWarnings("deprecation")
		RecipeChoice wibone = new RecipeChoice.ExactChoice(wbone);
		ShapedRecipe recipe = new ShapedRecipe(key, item); 
		recipe.shape("N N", "B B", "BBB");
		//recipe.setIngredient('I', Material.BEDROCK);
		recipe.setIngredient('N', Material.NETHERITE_INGOT);
		recipe.setIngredient('B', wibone); 
		return recipe;
}

public ShapedRecipe getWitherLegRecipe() {
	
	//wither bone leggings

			ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
			ItemMeta meta = item.getItemMeta();
			
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", 5, 
					Operation.ADD_NUMBER, EquipmentSlot.LEGS);
			meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
			AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "KnockbackResistance", 0.2, 
					Operation.ADD_NUMBER, EquipmentSlot.LEGS);
			meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier2);
			
			meta.setDisplayName(ChatColor.YELLOW + "Withering Leggings");
			meta.setCustomModelData(5553333);
			
			List<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6Full Set Bonus"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Fully charged melee attacks"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7  heal 50% of the damage dealt"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7- When damage is taken, "));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7  get Wither III for 3 seconds"));
			lore.add("");
			
			meta.setLore(lore);
			
			item.setItemMeta(meta);
			
			NamespacedKey key = new NamespacedKey(this, "wither_bone_leggings");
			keys.add(key);
			
			ItemStack wbone = new ItemStack(Material.BONE);
			ItemMeta meta2 = wbone.getItemMeta();
			meta2.setDisplayName(ChatColor.YELLOW + "Wither Bone");
			meta2.setCustomModelData(2222222);
			wbone.setItemMeta(meta2);
			
			@SuppressWarnings("deprecation")
			RecipeChoice wibone = new RecipeChoice.ExactChoice(wbone);
			ShapedRecipe recipe = new ShapedRecipe(key, item); 
			recipe.shape("BNB", "B B", "B B");
			//recipe.setIngredient('I', Material.BEDROCK);
			recipe.setIngredient('N', Material.NETHERITE_INGOT);
			recipe.setIngredient('B', wibone); 
			
			return recipe;
}

public ShapedRecipe getWitherBootsRecipe() {
	
	//wither bone boots

	ItemStack item = new ItemStack(Material.IRON_BOOTS);
	ItemMeta meta = item.getItemMeta();
	
	AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Health", 5, 
			Operation.ADD_NUMBER, EquipmentSlot.FEET);
	meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
	AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "KnockbackResistance", 0.2, 
			Operation.ADD_NUMBER, EquipmentSlot.FEET);
	meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier2);
	
	meta.setDisplayName(ChatColor.YELLOW + "Withering Boots");
	meta.setCustomModelData(5553334);
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.translateAlternateColorCodes('&', "&6Full Set Bonus"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Fully charged melee attacks"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  heal 50% of the damage dealt"));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7- When damage is taken, "));
	lore.add(ChatColor.translateAlternateColorCodes('&', "&7  get Wither III for 3 seconds"));
	lore.add("");
	
	meta.setLore(lore);
	
	item.setItemMeta(meta);
	
	NamespacedKey key = new NamespacedKey(this, "wither_bone_boots");
	keys.add(key);
	
	ItemStack wbone = new ItemStack(Material.BONE);
	ItemMeta meta2 = wbone.getItemMeta();
	meta2.setDisplayName(ChatColor.YELLOW + "Wither Bone");
	meta2.setCustomModelData(2222222);
	wbone.setItemMeta(meta2);
	
	@SuppressWarnings("deprecation")
	RecipeChoice wibone = new RecipeChoice.ExactChoice(wbone);
	ShapedRecipe recipe = new ShapedRecipe(key, item); 
	recipe.shape("   ", "BIB", "N N");
	//recipe.setIngredient('I', Material.BEDROCK);
	recipe.setIngredient('N', Material.NETHERITE_INGOT);
	recipe.setIngredient('B', wibone);
	return recipe;
}

@EventHandler
public void witherArmorBonusThing(EntityDamageByEntityEvent event) {
	//healing
	if (!(event.getDamager() instanceof Player)) {
		return;
	}
	Player player = (Player) event.getDamager();
	if (player.getInventory().getHelmet() == null) {
		return;
	}
	if (player.getInventory().getChestplate() == null) {
		return;
	}
	if (player.getInventory().getLeggings() == null) {
		return;
	}
	if (player.getInventory().getBoots() == null) {
		return;
	}
	if (!(player.getInventory().getHelmet().getItemMeta().hasCustomModelData())) {
		return;
	}
	if (!(player.getInventory().getChestplate().getItemMeta().hasCustomModelData())) {
		return;
	}
	if (!(player.getInventory().getLeggings().getItemMeta().hasCustomModelData())) {
		return;
	}
	if (!(player.getInventory().getBoots().getItemMeta().hasCustomModelData())) {
		return;
	}
	
	if (player.getInventory().getHelmet().getItemMeta().getCustomModelData() == 5553331 
			&& player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 5553332
			&& player.getInventory().getLeggings().getItemMeta().getCustomModelData() == 5553333
			&& player.getInventory().getBoots().getItemMeta().getCustomModelData() == 5553334) {
		if (player.getAttackCooldown() == 1) {
		double damage = event.getFinalDamage();
		double health = (0.5 * damage) + player.getHealth();
		if (40 >= health) {
		player.setHealth(health);
		}
		}
	}
	return;
	}
@EventHandler
public void witherArmorBonusThingTwo(EntityDamageEvent event) {
	// wither effect
	if (!(event.getEntity() instanceof Player)) {
		return;
	}
	Player player = (Player) event.getEntity();
	if (player.getInventory().getHelmet() == null) {
		return;
	}
	if (player.getInventory().getChestplate() == null) {
		return;
	}
	if (player.getInventory().getLeggings() == null) {
		return;
	}
	if (player.getInventory().getBoots() == null) {
		return;
	}
	if (!(player.getInventory().getHelmet().getItemMeta().hasCustomModelData())) {
		return;
	}
	if (!(player.getInventory().getChestplate().getItemMeta().hasCustomModelData())) {
		return;
	}
	if (!(player.getInventory().getLeggings().getItemMeta().hasCustomModelData())) {
		return;
	}
	if (!(player.getInventory().getBoots().getItemMeta().hasCustomModelData())) {
		return;
	}
	
	if (player.getInventory().getHelmet().getItemMeta().getCustomModelData() == 5553331 
			&& player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 5553332
			&& player.getInventory().getLeggings().getItemMeta().getCustomModelData() == 5553333
			&& player.getInventory().getBoots().getItemMeta().getCustomModelData() == 5553334) {
		
		World world = player.getWorld();
		if (!(event.getCause().equals(DamageCause.WITHER))) {
			if (event.getCause().equals(DamageCause.ENTITY_ATTACK)
					|| event.getCause().equals(DamageCause.ENTITY_EXPLOSION)
					|| event.getCause().equals(DamageCause.ENTITY_SWEEP_ATTACK)
					|| event.getCause().equals(DamageCause.PROJECTILE)) {
				if (player.isBlocking()) {
					return;
				}
			}
		world.playSound(player.getLocation(), Sound.ENTITY_WITHER_SKELETON_HURT, 4, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 2));
		}
	}
	return;
	}
public ShapedRecipe jumpElytraRecipe() {
	
	//test item for double jump

		ItemStack item = new ItemStack(Material.ELYTRA);
		ItemMeta meta = item.getItemMeta();
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Armor", 3, 
				Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.setDisplayName(ChatColor.YELLOW + "Jump Elytra");
		meta.setCustomModelData(1212121);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Double Jump"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7- Press jump in midair to jump"));
		lore.add("");
		
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(this, "jump_elytra");
		keys.add(key);
		
		ShapedRecipe recipe = new ShapedRecipe(key, item); 
		recipe.shape("NNN", "   ", "   ");
		//recipe.setIngredient('I', Material.BEDROCK);
		recipe.setIngredient('N', Material.NETHERITE_INGOT);
		return recipe;
}
@EventHandler
public void doubleJump(EntityToggleGlideEvent event) {
	if (!(event.getEntity() instanceof Player)) {
		return;
	}
	Player player = (Player)event.getEntity();
	if(player.isDead() == true) {
		return;
	}
	if(player.getInventory().getChestplate() == null) {
		return;
	}
	if(player.getInventory().getChestplate().getType() != Material.ELYTRA) {
		return;
	}
	
	if(player.getInventory().getChestplate().getItemMeta().hasCustomModelData()) {
		if(player.getInventory().getChestplate().getItemMeta().getCustomModelData() == 1212121) {
	if(player.isGliding() == false) {
		//player.sendMessage("start");
		//this is when elytra activates
		if(!(player.hasCooldown(Material.ELYTRA))) {
			player.setVelocity(player.getLocation().getDirection().multiply(1.1).setY(1));
			player.setCooldown(Material.ELYTRA, 40);
		}
		
		event.setCancelled(true);

		
	}
	if(player.isGliding() == true) {
		//this is when elytra lands on ground and deactivates
		//player.sendMessage("end");
		return;
	}
		}
	}
}
}
