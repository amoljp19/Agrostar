
package com.softaai.agrostarassigment.managers.listeners;

import com.softaai.agrostarassigment.model.Post;

public interface OnPostChangedListener {
    public void onObjectChanged(Post obj);

    public void onError(String errorText);
}
