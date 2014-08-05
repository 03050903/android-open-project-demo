package com.mingy.fancycoverflow.demo;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import at.technikum.mti.fancycoverflow.FancyCoverFlow;

import com.mingy.fancycoverflow.base.FancyCoverFlowBaseAdapter;


/**
 * һ��FancyCoverFlowʹ�ò��裺
 * 1����activity�Ĳ����ļ�������FancyCoverFlow��eg��
 * <at.technikum.mti.fancycoverflow.FancyCoverFlow
		android:id="@+id/fancyCoverFlowId"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:layout_centerVertical="true"
		fcf:maxRotation="45"
		fcf:unselectedAlpha="0.3"
		fcf:unselectedSaturation="0.0"
		fcf:unselectedScale="0.4"
		fcf:scaleDownGravity="0.5"
		/>
 * 
 * 
 * 2���Զ���Adapter��Adapter�̳���FancyCoverFlowBaseAdapter,eg��
 * 	public class FancyCoverFlowBaseAdapter extends FancyCoverFlowAdapter {
		public FancyCoverFlowBaseAdapter( Context context, Integer[] dataList ){
			mDataList = dataList;
		}
		
		@Override
		public int getCount() {
			return mDataList.length;
		}
	
		@Override
		public Object getItem(int position) {
			return mDataList[ position ];
		}
	
		@Override
		public long getItemId(int position) {
			return position;
		}
	
		@Override
		public View getCoverFlowItem(int position, View reusableView, ViewGroup parent) {
			ImageView imageView = null;
	
	        if (reusableView != null) {
	            imageView = (ImageView) reusableView;
	        } else {
	            imageView = new ImageView(parent.getContext());
	            imageView.setLayoutParams(new FancyCoverFlow.LayoutParams(LayoutParams.WRAP_CONTENT,256));
	        }
	
	        imageView.setBackgroundResource( mDataList[ position ] );
	        
	        return imageView;
		}
	
		private Integer[] mDataList = null;
	}
 * 
 * 
 * 3��ʵ����FancyCoverFlow��Ϊ������Adapter��eg
 * FancyCoverFlowBaseAdapter fancyCoverFlowBaseAdapter = new FancyCoverFlowBaseAdapter( this, getBaseDataList( ) );
   mFancyCoverFlow.setAdapter( fancyCoverFlowBaseAdapter );
 * 
 * 
 * ����ע�����
 * 1���ڲ����ļ�������FancyCoverFlowʱ�������Ҫʹ���Զ������ԣ�����Ҫ�ڸ������ļ��ж����Զ������Ե������ռ䡰xmlns:fcf="http://schemas.android.com/apk/res-auto"����
 * 2��FancyCoverFlow��Ч���ǻ��ڻ���Gallery�ģ��������Զ���Adapterʱ������getCoverFlowItem������һ��Ҫע���Զ���view�����ԣ�����μ���demo�е�FancyCoverFlowBaseAdapter�ࣻ
 * */
public class FancyCoverFlowMainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_fancycoverflow_layout);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void findViews() {
		mFancyCoverFlowList = ( ListView )findViewById( R.id.fancyCoverFlowListId );
		mFancyCoverFlow = ( FancyCoverFlow )findViewById( R.id.fancyCoverFlowId );
	}
	
	@Override
	public void getData() {
		
	}
	
	@Override
	public void showContent() {
		initFancyCoverFlowList( );
		showFancyCoverFlow( 0 );
	}
	
	private void initFancyCoverFlowList( ){
		mFancyCoverFlowList.setOnItemClickListener( new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				showFancyCoverFlow( arg2 );
			}
		});
		
		mFancyCoverFlowList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getListData()));
	}
	
	private void showFancyCoverFlow( int position ){
		switch( position ){
		case 0:{
			showBaseCoverFlow( );
		}
		break;
		default:{
			
		}
		break;
		}
	}
	
	private void showBaseCoverFlow( ){
		FancyCoverFlowBaseAdapter fancyCoverFlowBaseAdapter = new FancyCoverFlowBaseAdapter( this, getBaseDataList( ) );
		mFancyCoverFlow.setAdapter( fancyCoverFlowBaseAdapter );
	}
	
	private ArrayList<String> getListData( ){
		ArrayList<String> listData = new ArrayList<String>( );
		
		listData.add( "Base FancyCoverFlow" );
		
		return listData;
	}
	
	private Integer[] getBaseDataList( ){
		Integer[] baseData = new Integer[]{R.drawable.h5, R.drawable.h8, R.drawable.h8s, R.drawable.h9, R.drawable.h10 };
		
		return baseData;
	}
	
	private ListView mFancyCoverFlowList = null;
	private FancyCoverFlow mFancyCoverFlow = null;
}
