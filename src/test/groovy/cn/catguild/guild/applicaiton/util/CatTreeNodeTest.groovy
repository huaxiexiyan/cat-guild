package cn.catguild.guild.applicaiton.util

import cn.catguild.test.support.JSONUtils
import spock.lang.Specification

import static org.assertj.core.api.BDDAssertions.then

class CatTreeNodeTest extends Specification {

    def "平铺树节点合并成森林"() {
        given:
        def testJson = getTestJson()
        List<TestNode> testNode = JSONUtils.parseArray(testJson, TestNode.class)
        when:
        List<TestNode> actual = CatTreeNode.merge(testNode)
        then:
        def json = getExpectJson()
        List<TestNode> expect = JSONUtils.parseArray(json, TestNode.class)
        // 断言 list 复杂对象，需要重新 equals 与 hashCode
        then(actual).containsExactlyElementsOf(expect)
    }

    def "test list"(){
        given:
        when:
        def testJson = """
            [{"id":1,"parentId":0,"children":[]},
            {"id":3,"parentId":0,"children":[
                    {"id":16,"parentId":3,"children":[]},
                    {"id":18,"parentId":3,"children":[
                            {"id":19,"parentId":18,"children":[]}
                        ]
                    }
                ]
            }]
        """
        List<TestNode> actual = JSONUtils.parseArray(testJson, TestNode.class)
        then:
        def expectJson = """
            [{"id":1,"parentId":0,"children":[]},
            {"id":3,"parentId":0,"children":[
                    {"id":16,"parentId":3,"children":[]},
                    {"id":18,"parentId":3,"children":[
                            {"id":19,"parentId":18,"children":[]}
                        ]
                    }
                ]
            }]
        """
        List<TestNode> expect = JSONUtils.parseArray(expectJson, TestNode.class)
        // 断言 list 复杂对象，需要重新 equals 与 hashCode
        then(actual).containsExactlyElementsOf(expect)
    }

    String getTestJson() {
        return"""
        [
            {"id":1,"parentId":0,"children":[]},
            {"id":2,"parentId":0,"children":[]},
            {"id":3,"parentId":0,"children":[]},
            {"id":4,"parentId":1,"children":[]},
            {"id":5,"parentId":1,"children":[]},
            {"id":6,"parentId":1,"children":[]},
            {"id":7,"parentId":4,"children":[]},
            {"id":8,"parentId":4,"children":[]},
            {"id":9,"parentId":5,"children":[]},
            {"id":10,"parentId":8,"children":[]},
            {"id":11,"parentId":2,"children":[]},
            {"id":12,"parentId":2,"children":[]},
            {"id":13,"parentId":11,"children":[]},
            {"id":14,"parentId":13,"children":[]},
            {"id":15,"parentId":14,"children":[]},
            {"id":16,"parentId":3,"children":[]},
            {"id":17,"parentId":3,"children":[]},
            {"id":18,"parentId":3,"children":[]},
            {"id":19,"parentId":18,"children":[]},
            {"id":20,"parentId":18,"children":[]},
            {"id":21,"parentId":0,"children":[]}
        ]
        """
    }

    String getExpectJson() {
        return"""
        [
            {"id":1,"parentId":0,"children":[
                    {"id":4,"parentId":1,"children":[
                            {"id":7,"parentId":4,"children":[]},
                            {"id":8,"parentId":4,"children":[
                                    {"id":10,"parentId":8,"children":[]}
                                ]
                            }
                        ]
                    },
                    {"id":5,"parentId":1,"children":[
                            {"id":9,"parentId":5,"children":[]}
                        ]
                    },
                    {"id":6,"parentId":1,"children":[]}
                 ]
            },
            {"id":2,"parentId":0,"children":[
                    {"id":11,"parentId":2,"children":[
                            {"id":13,"parentId":11,"children":[
                                    {"id":14,"parentId":13,"children":[
                                            {"id":15,"parentId":14,"children":[]}
                                        ]
                                    }
                                ]
                            }
                        ]
                    },
                    {"id":12,"parentId":2,"children":[]}
                ]
            },
            {"id":3,"parentId":0,"children":[
                    {"id":16,"parentId":3,"children":[]},
                    {"id":17,"parentId":3,"children":[]},
                    {"id":18,"parentId":3,"children":[
                            {"id":19,"parentId":18,"children":[]},
                            {"id":20,"parentId":18,"children":[]}
                        ]
                    }
                ]
            },
            {"id":21,"parentId":0,"children":[]}
        ]
        """
    }

    static class TestNode implements CatTreeNode<TestNode, Long> {

        Long id;
        Long parentId;
        List<TestNode> children;

        TestNode() {

        }

        TestNode(Long id, Long parentId) {
            this.id = id;
            this.parentId = parentId;
        }

        TestNode(Long id, Long parentId, List<TestNode> children) {
            this.id = id;
            this.parentId = parentId;
            this.children = children;
        }

        @Override
        Long getId() {
            return id
        }

        @Override
        Long getParentId() {
            return parentId
        }

        @Override
        Collection<TestNode> getChildren() {
            return children
        }

        @Override
        void setChildren(Collection<TestNode> children) {
            this.children = children
        }

        boolean equals(o) {
            if (this.is(o)) return true
            if (getClass() != o.class) return false

            TestNode testNode = (TestNode) o

            if (children != testNode.children) return false
            if (id != testNode.id) return false
            if (parentId != testNode.parentId) return false

            return true
        }

        int hashCode() {
            int result
            result = (id != [] ? id.hashCode() : 0)
            result = 31 * result + (parentId != [] ? parentId.hashCode() : 0)
            result = 31 * result + (children != [] ? children.hashCode() : 0)
            return result
        }

        @Override
        public String toString() {
            return "TestNode{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
        }
    }

}
