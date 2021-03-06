package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelGrizzle;
import naturix.divinerpg.entities.entity.vanilla.GrizzleWhite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGrizzleWhite extends RenderLiving<GrizzleWhite> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/grizzle_white.png");
	private final ModelGrizzle ModelAyereco;
    
	public RenderGrizzleWhite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGrizzle(), 1F);
        ModelAyereco = (ModelGrizzle) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(GrizzleWhite entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<GrizzleWhite> {

	        @Override
	        public Render<? super GrizzleWhite> createRenderFor(RenderManager manager) {
	            return new RenderGrizzleWhite(manager, new ModelGrizzle(), 0.5F);
	        }
	    }

	}