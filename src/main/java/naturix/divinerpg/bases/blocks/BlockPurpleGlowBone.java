package naturix.divinerpg.bases.blocks;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPurpleGlowBone extends BlockBase implements IPlantable {

	static float var3 = 0.375F;
	public static final AxisAlignedBB FULL_BLOCK_AABB = new AxisAlignedBB(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
	public BlockPurpleGlowBone(String name) {
		super(name);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setTickRandomly(true);
		setCreativeTab(null);
	}
 
	public void onBlockAdded(World par1World, int par2, int par3, int par4) { }
//
//	@Override
//    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
//    int	i=pos.getX();
//	int j=pos.getY();
//	int k=pos.getZ();
//	BlockPos pos2 = new BlockPos(i, j+1, k);
//	BlockPos pos3 = new BlockPos(i, j-1, k);
//		if(world.isAirBlock(pos2) && world.getBlockState(pos) == Blocks.AIR && world.getBlockState(pos3) == Blocks.GRASS) {
//			world.setBlockState(pos2, this, 2);
//			world.setBlockState(pos, this, 1);
//		}
//	}
//	
//	@Override
//	public boolean canBlockStay(World w, int x, int y, int z) {
//		return w.getBlock(x, y - 1, z) == this || w.getBlock(x, y - 1, z) == Blocks.grass;
//	}
//
//	@Override
//	public boolean canPlaceBlockAt(World w, int x, int y, int z) {
//		return true;
//	}
//	
//	@Override
//	public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
//		this.checkBlockCoordValid(w, x, y, z);
//	}
//
//	protected void checkBlockCoordValid(World world, int i, int j, int k) {
//		if(!this.canBlockStay(world, i, j, k)) {
//			if(world.getBlockMetadata(i, j, k) == 2)this.dropBlockAsItemWithChance(world, i, j, k, world.getBlockMetadata(i, j, k), 1f, 0);
//			else if(world.getBlockMetadata(i, j, k) == 0)this.dropBlockAsItem(world, i, j, k, new ItemStack(TwilightItemsCrops.purpleGlowboneSeeds));
//			world.breakBlock(i, j, k, false);
//		}else if(world.getBlockMetadata(i, j, k) != 0 && world.getBlock(i, j+1, k) != this){
//			world.setBlock(i, j, k, this, 0, 2);
//		}
//	}
//
//	@Override
//	public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
//		return null;
//	}
//	
//	@Override
//	public Item getItemDropped(int meta, Random rand, int fortune){
//		return TwilightItemsCrops.purpleGlowboneSeeds;
//	}
//	
//	@Override
//	public int quantityDropped(Random rand) {
//		return 1+rand.nextInt(2);
//	}
//
//	@Override
//	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
//    {
//		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
//		if(meta == 2){
//			drops.add(new ItemStack(TwilightItemsCrops.purpleGlowbone, 1));
//			drops.add(new ItemStack(this.getItemDropped(0, this.rand, 0), this.quantityDropped(this.rand)));
//		}
//		if(meta == 0){
//			drops.add(new ItemStack(this.getItemDropped(0, this.rand, 0), 1));
//		}
//		return drops;
//    }

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModItems.seedsGlowbonePurple);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return EnumPlantType.Beach;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.getDefaultState();
	}

}