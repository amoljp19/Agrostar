

package com.softaai.agrostarassigment.adapters;

import android.support.v7.widget.RecyclerView;

import com.softaai.agrostarassigment.activities.BaseActivity;
import com.softaai.agrostarassigment.managers.PostManager;
import com.softaai.agrostarassigment.managers.listeners.OnPostChangedListener;
import com.softaai.agrostarassigment.model.Post;
import com.softaai.agrostarassigment.utils.LogUtil;

import java.util.LinkedList;
import java.util.List;

public abstract class BasePostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = BasePostsAdapter.class.getSimpleName();

    protected List<Post> postList = new LinkedList<>();
    protected BaseActivity activity;
    protected int selectedPostPosition = -1;

    public BasePostsAdapter(BaseActivity activity) {
        this.activity = activity;
    }

    protected void cleanSelectedPostInformation() {
        selectedPostPosition = -1;
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return postList.get(position).getItemType().getTypeCode();
    }

    protected Post getItemByPosition(int position) {
        return postList.get(position);
    }

    private OnPostChangedListener createOnPostChangeListener(final int postPosition) {
        return new OnPostChangedListener() {
            @Override
            public void onObjectChanged(Post obj) {
                postList.set(postPosition, obj);
                notifyItemChanged(postPosition);
            }

            @Override
            public void onError(String errorText) {
                LogUtil.logDebug(TAG, errorText);
            }
        };
    }

    public void updateSelectedPost() {
        if (selectedPostPosition != -1) {
            Post selectedPost = getItemByPosition(selectedPostPosition);
            PostManager.getInstance(activity).getSinglePostValue(selectedPost.getId(), createOnPostChangeListener(selectedPostPosition));
        }
    }
}
