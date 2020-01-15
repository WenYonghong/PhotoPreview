package nlwl.lanaer.ui.pagerpreviewlib.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import nlwl.lanaer.ui.pagerpreviewlib.R;
import nlwl.lanaer.ui.pagerpreviewlib.custom.PhotoView;
import nlwl.lanaer.ui.pagerpreviewlib.model.PreviewMoel;

/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.picture.ui
 * email：邮箱->893855882@qq.com
 * data：17/01/18
 */
public class PictureImagePreviewFragment extends Fragment {

    public static PictureImagePreviewFragment getInstance(PreviewMoel media) {
        PictureImagePreviewFragment fragment = new PictureImagePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", media);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.picture_fragment_image_preview, container, false);
        final PhotoView imageView = (PhotoView) contentView.findViewById(R.id.preview_image);
        PreviewMoel media = (PreviewMoel) getArguments().getSerializable("data");
        System.out.println("打印数据:"+media.getPath());
        Glide.with(container.getContext())
                .load(media.getPath()).apply(new RequestOptions().override(1080, 1920).placeholder(R.drawable.lanaer_moren)
                .error(R.drawable.lanaer_moren))
                .into(imageView);

        return contentView;
    }


}
