package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import net.minecraft.client.model.ModelZombie;
import naturix.divinerpg.entities.entity.vanilla.Miner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMiner extends RenderLiving<Miner> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/miner.png");
	private final ModelZombie ModelZombie;
    
	public RenderMiner(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelZombie(), 1F);
        ModelZombie = (ModelZombie) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Miner entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Miner> {

	        @Override
	        public Render<? super Miner> createRenderFor(RenderManager manager) {
	            return new RenderMiner(manager, new ModelZombie(), 0.5F);
	        }
	    }

	}