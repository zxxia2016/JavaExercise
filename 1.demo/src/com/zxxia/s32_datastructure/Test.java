package com.zxxia.s32_datastructure;

import com.zxxia.iTest;

/**
 * 常见数据结构
 * 1. 栈：先进后出，后进先出；例子：弹夹
 * 2。 队列：先进先出，后进后出；例子：排队买东西
 * 3. 数组；连续内存，查询速度快，因为可以通过索引获取，任意位置索引查询一样；增加、删除元素效率低
 * 4. 链表：不连续内存，查询速度慢，有索引也要遍历；增加、删除元素快；首尾操作快
 *
 * --单向链表
 * --双向链表
 * 5. 二叉树：
 * --特点
 * ----只能有一个节点；
 * ----每个节点最多只有2个节点（1-2个节点）；
 * ----度（叶子数目）
 * ----高度（从根节点到最深节点的最长路径的节点数）
 * ----层（即行）
 * ----兄弟节点
 * --分类
 * ----普通二叉树（没排序）
 * ----二叉查找树（排序号），二分查找的原理；提供增删改查性能；存在的问题：瘸子问题：例如：7-10，依次插入11、12、13、14；这问题诞生了平衡二叉树
 * ----平衡二叉树：任意节点高度不差1；如何平衡：左旋、右旋
 * ----红黑树：高度通过”红黑规则“来平衡；增删改查性能都好
 */
class HashTest implements iTest {

    @Override
    public void run() {
        String heima = "heima";
        System.out.println(heima.hashCode());
    }
}

public class Test {
    public static void main(String[] args) {
        HashTest hashTest = new HashTest();
        hashTest.run();
    }
}
