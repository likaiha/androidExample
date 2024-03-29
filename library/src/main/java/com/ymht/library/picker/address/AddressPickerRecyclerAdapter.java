package com.ymht.library.picker.address;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ymht.library.R;

import java.util.ArrayList;

public class AddressPickerRecyclerAdapter extends RecyclerView.Adapter<AddressPickerRecyclerAdapter.AddressPickerRecyclerViewHolder> {

    private ArrayList<AddressBean> list;
    private LinearLayoutManager manager;
    private OnItemClickListener listener;
    private int selectPosition = -1;

    private int textSelectedColor = Color.parseColor("#AE2B2B");//item的text选中的颜色
    private int textUnselectedColor = Color.parseColor("#AE2B2B");//item的text未选中的颜色
    private int imageResourceId = R.drawable.address_select;

    public AddressPickerRecyclerAdapter(ArrayList<AddressBean> list, LinearLayoutManager manager) {
        this.list = list;
        this.manager = manager;
    }

    @NonNull
    @Override
    public AddressPickerRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_picker_recycler_item, parent, false);
        AddressPickerRecyclerViewHolder viewHolder = new AddressPickerRecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddressPickerRecyclerViewHolder holder, int position) {
        holder.mAddressPickerItemText.setText(list.get(position).getName());
        holder.mAddressPickerItemText.setTextColor(createColorStateList(textSelectedColor, textUnselectedColor));
        holder.mAddressPickerItemImage.setImageResource(imageResourceId);

        //根据选中的位置是否等于position(selectPosition == position)来判断是否选中，解决复用
        holder.itemView.setSelected(selectPosition == position);//mSelectedTagList.contains(position)即为布尔类型
        //selectPosition == position ? View.VISIBLE : View.GONE，用三目运算符赋值，就好比如int a = selectPosition == position ? View.VISIBLE : View.GONE；
        //如果selectPosition == position，就把View.VISIBLE赋值给a，反之亦然。
        holder.mAddressPickerItemImage.setVisibility(selectPosition == position ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AddressPickerRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mAddressPickerItemText;
        private ImageView mAddressPickerItemImage;

        public AddressPickerRecyclerViewHolder(View itemView) {
            super(itemView);
            mAddressPickerItemText = itemView.findViewById(R.id.address_picker_item_text);
            mAddressPickerItemImage = itemView.findViewById(R.id.address_picker_item_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(getLayoutPosition(), mAddressPickerItemText.getText().toString());
                    }
                    if (selectPosition >= manager.findFirstVisibleItemPosition() && selectPosition <= manager.findLastVisibleItemPosition()) {
                        manager.findViewByPosition(selectPosition).setSelected(false);
                        manager.findViewByPosition(selectPosition).findViewById(R.id.address_picker_item_image).setVisibility(View.GONE);
                    }
                    //设置点击的item选中（使用LayoutManager来获取Item）
                    manager.findViewByPosition(getLayoutPosition()).setSelected(true);
                    //设置对号显示
                    manager.findViewByPosition(getLayoutPosition()).findViewById(R.id.address_picker_item_image).setVisibility(View.VISIBLE);
                    //可以根据selectPosition的标记以用来解决复用问题
                    selectPosition = getLayoutPosition();
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * 对TextView设置不同状态时其文字颜色。用ColorStateList实现替代selector
     */
    private ColorStateList createColorStateList(int selected, int normal) {
        int[] colors = new int[]{selected, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_selected};
        states[1] = new int[]{-android.R.attr.state_selected};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    /**
     * 设置列表中item名字的选中和未选中颜色
     *
     * @param textSelectedColor
     * @param textUnselectedColor
     */
    public void setTextColor(int textSelectedColor, int textUnselectedColor) {
        this.textSelectedColor = textSelectedColor;
        this.textUnselectedColor = textUnselectedColor;
    }

    /**
     * 设置列表中item对号的资源图片
     *
     * @param imageResourceId
     */
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void scrollToSelectedPosition() {
        manager.scrollToPositionWithOffset(selectPosition, 0);
    }
}
