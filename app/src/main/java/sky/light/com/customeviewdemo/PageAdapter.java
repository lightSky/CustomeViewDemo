package sky.light.com.customeviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import salvage.RecyclingPagerAdapter;

public class PageAdapter  extends RecyclingPagerAdapter{
    private static final int[] mDrawableResIds = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
	private Context mContext;
	private LayoutInflater inflater;

    public PageAdapter(Context context) {
		mContext = context;
		inflater = LayoutInflater.from(context);
	}
	
    /**
     * get really position
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return  position % mDrawableResIds.length ;
    }

    @Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup container) {
        ViewHolder holder = null;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_page, container, false);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }

        holder.image.setImageResource(mDrawableResIds[position % mDrawableResIds.length]);
        return convertView;
	}

    private static class ViewHolder {
        ImageView image;
    }
}