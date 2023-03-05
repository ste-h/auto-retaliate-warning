package autoretaliatewarning;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("autoretaliatewarning")
public interface AutoRetaliateWarningConfig extends Config
{
	@ConfigItem(
		keyName = "hideRetaliateConfig",
		name = "Hide Auto Retaliate",
		description = "Hides the auto retaliate button"
	)
	default boolean hideRetaliateConfig()
	{
		return false;
	}
}
