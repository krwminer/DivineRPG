package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelGrizzle;
import naturix.divinerpg.entities.entity.vanilla.Grizzle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGrizzle extends RenderLiving<Grizzle> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/grizzle.png");
	private final ModelGrizzle ModelAyereco;
    
	public RenderGrizzle(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGrizzle(), 1F);
        ModelAyereco = (ModelGrizzle) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Grizzle entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Grizzle> {

	        @Override
	        public Render<? super Grizzle> createRenderFor(RenderManager manager) {
	            return new RenderGrizzle(manager, new ModelGrizzle(), 0.5F);
	        }
	    }

	}