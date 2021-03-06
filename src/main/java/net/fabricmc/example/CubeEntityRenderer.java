package net.fabricmc.example;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {
 
    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(ClientMod.MODEL_CUBE_LAYER)), 0.5f);
    }
 
    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("modid", "textures/entity/cube/cube.png");
    }
}