package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelAyeraco;
import naturix.divinerpg.entities.entity.vanilla.AyeracoYellow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAyeracoYellow extends RenderLiving<AyeracoYellow> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ayeraco_yellow.png");
	private final ModelAyeraco ModelAyereco;
    
	public RenderAyeracoYellow(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAyeraco(), 1F);
        ModelAyereco = (ModelAyeraco) super.mainModel;

    } 


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(AyeracoYellow entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<AyeracoYellow> {

	        @Override
	        public Render<? super AyeracoYellow> createRenderFor(RenderManager manager) {
	            return new RenderAyeracoYellow(manager, new ModelAyeraco(), 0.5F);
	        }
	    }

	}