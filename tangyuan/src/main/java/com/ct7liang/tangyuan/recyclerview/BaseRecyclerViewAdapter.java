package com.ct7liang.tangyuan.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by xsw on 2016/12/2.
 *
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //条目点击事件监听
    public OnItemClickListener mClickListener;

    //条目长按事件监听
    public OnItemLongClickListener mLongListener;

    //加载更多事件监听
    public OnLoadMoreListener mLoadMoreListener;

    public WeakReference<Context> mContext;


    public void setOnItemClickListener(OnItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener mLongListener) {
        this.mLongListener = mLongListener;
    }
    public void setOnLoadMoreListener(OnLoadMoreListener mLoadMoreListener) {
        this.mLoadMoreListener = mLoadMoreListener;
    }

    public BaseRecyclerViewAdapter(Context context) {
        mContext = new WeakReference<Context>(context);
    }

    public BaseRecyclerViewAdapter(Context context, T t) {
        mContext = new WeakReference<Context>(context);
    }

    public abstract class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public ContentViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class NoMoreViewHolder extends ContentViewHolder{
        public NoMoreViewHolder(View itemView) {
            super(itemView);
        }
        @Override
        public void onClick(View view) {}
        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}