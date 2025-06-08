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
		keyName = "autoRetaliateWarn",
		name = "Warn Auto Retaliate",
		description = "Warns you when you have auto retaliate enabled"
	)
	default boolean autoRetaliateWarn()
	{
		return true;
	}
	@ConfigItem(
		position = 3,
		keyName = "autoRetaliateOffWarn",
		name = "Warn Auto Retaliate Off",
		description = "Warns you when you have auto retaliate disabled"
	)
	default boolean autoRetaliateOffWarn()
	{
		return false;
	}
	@ConfigItem(
		position = 4,
		keyName = "hideRetaliateConfig",
		name = "Hide Auto Retaliate",
		description = "Hides the auto retaliate button"
	)
	default boolean hideRetaliateConfig()
	{
		return false;
	}
	@ConfigItem(
		position = 5,
		keyName = "fontSize",
		name = "Font Size",
		description = "Changes the warnings font size"
	)
	default int fontSize()
	{
		return 20;
	}
}
