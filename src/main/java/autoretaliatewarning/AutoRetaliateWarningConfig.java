package autoretaliatewarning;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("autoretaliatewarning")
public interface AutoRetaliateWarningConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "npcAttackOptionsWarn",
		name = "Warn NPC attack options",
		description = "Warns you when NPC attack options aren't hidden"
	)
	default boolean npcAttackOptionsWarn()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "npcAttackOptionsText",
		name = "NPC Attack Options Warning Text",
		description = "Custom text to display when NPC attack options aren't hidden"
	)
	default String npcAttackOptionsText()
	{
		return "NPC ATTACK OPTIONS NOT HIDDEN";
	}

	@ConfigItem(
		position = 3,
		keyName = "autoRetaliateWarn",
		name = "Warn Auto Retaliate",
		description = "Warns you when you have auto retaliate enabled"
	)
	default boolean autoRetaliateWarn()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "autoRetaliateText",
		name = "Auto Retaliate On Warning Text",
		description = "Custom text to display when auto retaliate is enabled"
	)
	default String autoRetaliateText()
	{
		return "AUTO RETALIATE IS SELECTED";
	}

	@ConfigItem(
		position = 5,
		keyName = "autoRetaliateOffWarn",
		name = "Warn Auto Retaliate Off",
		description = "Warns you when you have auto retaliate disabled"
	)
	default boolean autoRetaliateOffWarn()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "autoRetaliateOffText",
		name = "Auto Retaliate Off Warning Text",
		description = "Custom text to display when auto retaliate is disabled"
	)
	default String autoRetaliateOffText()
	{
		return "AUTO RETALIATE IS OFF";
	}

	@ConfigItem(
		position = 7,
		keyName = "hideRetaliateConfig",
		name = "Hide Auto Retaliate",
		description = "Hides the auto retaliate button"
	)
	default boolean hideRetaliateConfig()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "fontSize",
		name = "Font Size",
		description = "Changes the warnings font size"
	)
	default int fontSize()
	{
		return 20;
	}
}