package com.util;

import com.entity.Dep;
import com.util.TimeUtil;
import net.sf.json.JSONArray;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 格式化map数据
 */
public class MapUtil {

    public Map<String,Object> format(List<Dep> list){

        //创建Map对象
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        Map<String,Object> depmap = new LinkedHashMap<String, Object>();
        Map<String,Object> empmap = new HashMap<String, Object>();

        for (Dep d : list){
            empmap.put("姓名",d.getEmp().getName());
            empmap.put("电话",d.getEmp().getTel());
            empmap.put("入职时间", TimeUtil.TimeStamp2Year(d.getEmp().getInTime()));
            empmap.put("职级",d.getEmp().getType());
            depmap.put("部门名称",d.getName());
            depmap.put("部门编号",d.getNo());
            depmap.put("员工",empmap);

            //向Map对象中绑定二个变量
            //map.put("total",list.size());
            map.put("data",depmap);
        }



        map.put("status","success");
        return map;
    }

    public JSONArray getJsonByList(List<Dep> list){

        JSONArray jsonArray = new JSONArray();
        if (list==null ||list.isEmpty()) {
            return jsonArray;//nerver return null
        }

        for (Dep dep : list) {
            jsonArray.add(dep);
        }
        return jsonArray;
    }
}
