

package com.softaai.agrostarassigment.managers.listeners;

import com.softaai.agrostarassigment.model.PostListResult;

public interface OnPostListChangedListener<Post> {

    public void onListChanged(PostListResult result);

    void onCanceled(String message);
}
