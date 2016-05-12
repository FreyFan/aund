package com.kd.platform.echarts.samples.force;

import com.kd.platform.echarts.Label;
import com.kd.platform.echarts.code.*;
import com.kd.platform.echarts.series.Force;
import com.kd.platform.echarts.series.force.Link;
import com.kd.platform.echarts.series.force.Node;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Application name:</b> ForceTest2.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ForceTest2 {
    private static final int MIN_RADIUS = 2;

    private static final int MAX_RADIUS = 10;

    private static final int MAX_DEPTH = 2;

    private static final int MIN_CHILDREN = 4;

    private static final int MAX_CHILDREN = 7;

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/force2.html
        // 准备数据
        List<Node> nodes = new ArrayList<Node>();
        List<Link> links = new ArrayList<Link>();
        forceMockThreeData(nodes, links);
        // 创建option
        EnhancedOption option = new EnhancedOption();
        option.title().text("Force").subtext("Force-directed tree").x(X.right).y(Y.bottom);
        option.tooltip().trigger(Trigger.item).formatter("{a} : {b}");
        option.toolbox().show(true).feature(Tool.restore, Tool.saveAsImage);
        option.legend().x(X.left).data("叶子节点", "非叶子节点", "根节点");
        // 数据
        Force force = new Force("Force tree");
        force.categories("叶子节点", "非叶子节点", "根节点");
        force.itemStyle().normal().label(new Label().show(false)).nodeStyle().brushType(BrushType.both).color("rgba(255,215,0,0.6)").borderWidth(1);
        force.minRadius(MIN_RADIUS).maxRadius(MAX_RADIUS);
        force.coolDown(0.995).steps(10);
        force.nodes(nodes).links(links);
        option.series(force);
        option.exportToHtml("force2.html");
        option.view();
    }

    private int rangeRandom(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    private Node createRandomNode(List<Node> nodes, int depth) {
        Node node = new Node();
        node.name("NODE_" + nodes.size());
        node.value(rangeRandom(MIN_RADIUS, MAX_RADIUS));
        node.put("id", nodes.size());
        node.put("depth", depth);
        node.category(depth == MAX_DEPTH ? 0 : 1);
        nodes.add(node);
        return node;
    }

    private Node rootNode() {
        Node node = new Node();
        node.name("ROOT");
        node.value(rangeRandom(MIN_RADIUS, MAX_RADIUS));
        node.put("id", 0);
        node.put("depth", 0);
        node.category(2);
        return node;
    }

    private void forceMockThreeData(List<Node> nodes, List<Link> links) {
        Node root = rootNode();
        nodes.add(root);
        mock(nodes, links, root, 0);
    }

    private void mock(List<Node> nodes, List<Link> links, Node parent, int depth) {
        int nChildNode = Math.round(rangeRandom(MIN_CHILDREN, MAX_CHILDREN));
        for (int i = 0; i < nChildNode; i++) {
            Node childNode = createRandomNode(nodes, depth);
            Link link = new Link();
            link.source(parent.get("id")).target(childNode.get("id")).weight(1);
            links.add(link);
            if (depth < MAX_DEPTH) {
                mock(nodes, links, childNode, depth + 1);
            }
        }
    }
}
