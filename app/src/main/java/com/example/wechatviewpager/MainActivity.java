package com.example.wechatviewpager;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnPageChange;

public class MainActivity extends FragmentActivity {
    @BindView(R2.id.rb_chat)
    RadioButton rbChat;
    @BindView(R2.id.rb_contacts)
    RadioButton rbContacts;
    @BindView(R2.id.rb_discovery)
    RadioButton rbDiscovery;
    @BindView(R2.id.rb_me)
    RadioButton rbMe;
    @BindView(R2.id.rg_select)
    RadioGroup radioGroup;
    @BindView(R2.id.vp_viewpager)
    ViewPager vpViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        ChatFragment weChatFragment = new ChatFragment();
        ContactsFragment contactsFragment = new ContactsFragment();
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        MeFragment meFragment = new MeFragment();
        List<Fragment> alFragment = new ArrayList<Fragment>();
        alFragment.add(weChatFragment);
        alFragment.add(contactsFragment);
        alFragment.add(discoveryFragment);
        alFragment.add(meFragment);
        //ViewPager设置适配器
        vpViewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), alFragment));
        //ViewPager显示第一个Fragment
        vpViewpager.setCurrentItem(0);
    }

    /**
     * 设置radioGroup的监听事件
     * @param view
     * @param ischanged
     */
    @OnCheckedChanged({R2.id.rb_chat, R2.id.rb_contacts, R2.id.rb_discovery, R2.id.rb_me,})
    public void OnCheckChangeListner(CompoundButton view, boolean ischanged) {
        switch (view.getId()) {
            case R.id.rb_chat:
                if (ischanged) {
                    vpViewpager.setCurrentItem(0, false);
                }
                break;
            case R.id.rb_contacts:
                if (ischanged) {
                    vpViewpager.setCurrentItem(1, false);
                }
                break;
            case R.id.rb_discovery:
                if (ischanged) {
                    vpViewpager.setCurrentItem(2, false);
                }
                break;
            case R.id.rb_me:
                if (ischanged) {
                    vpViewpager.setCurrentItem(3, false);
                }
                break;
        }
    }

    /**
     * 设置viewpager的监听事件
     * @param position
     */
    @OnPageChange({R2.id.vp_viewpager})
    public void OnPageChangeListner(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.rb_chat);
                break;
            case 1:
                radioGroup.check(R.id.rb_contacts);
                break;
            case 2:
                radioGroup.check(R.id.rb_discovery);
                break;
            case 3:
                radioGroup.check(R.id.rb_me);
                break;
        }
    }

}
