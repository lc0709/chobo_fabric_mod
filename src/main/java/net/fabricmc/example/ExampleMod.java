package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;

//import net.fabricmc.fabric.api.registry.*;
//import net.fabricmc.fabric.impl.registry.*;

//import java.rmi.registry.Registry;,<- *IMPOSTER.*

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	
	
	public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(64));
	
	public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("modid", "cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new)
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
	
	public static final Item CUBE_SPAWN_EGG = new SpawnEggItem(ExampleMod.CUBE, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("modid", "fabric_item"), FABRIC_ITEM);
		LOGGER.info("Hello Fabric world!");
		
		FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());
		
		Registry.register(Registry.ITEM, new Identifier("modid", "cube_spawn_egg"), CUBE_SPAWN_EGG);
	}

}
/*
*   뭘만들까요
*	일단 보스전인데
*	약간의 초반 색다름이 있는 RPG가 마렵다.
*	 
*	컨셉이 힘드네 일단 무지성 보스부터 만들기 ㄱㄱ
*	활이 안먹는 느낌 활 사기임 
*	밀쳐내고 하는 패턴 있으면 좋을듯
*	블럭도 부셔야됨
*	
*	던전식
*	주민마을 생성 비슷한느낌
*	
*	스탯 마렵다.
*	
*
*
*
*/