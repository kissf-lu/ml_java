package alg.classification;

import com.alibaba.alink.operator.batch.BatchOperator;
import com.alibaba.alink.operator.batch.source.MemSourceBatchOp;
import com.alibaba.alink.operator.stream.StreamOperator;
import com.alibaba.alink.operator.stream.source.MemSourceStreamOp;
import com.alibaba.alink.pipeline.classification.C45;
import org.apache.flink.types.Row;
import java.util.Arrays;
import java.util.List;

/** app main part.
 * @author l00561440 lujian
 * @version  v1.0
 * @since JDK1.8
 *
 */
public class C45C {

    public C45C() {
    }

    public void c45Test() throws Exception{

        List<Row> df = Arrays.asList(
                Row.of(1.0, "A", 0, 0, 0),
                Row.of(2.0, "B", 1, 1, 0),
                Row.of(3.0, "C", 2, 2, 1),
                Row.of(4.0, "D", 3, 3, 1)
        );
        BatchOperator<?> batchSource = new MemSourceBatchOp(
                df, " f0 double, f1 string, f2 int, f3 int, label int");
        StreamOperator<?> streamSource = new MemSourceStreamOp(
                df, " f0 double, f1 string, f2 int, f3 int, label int");
        new C45()
                .setPredictionDetailCol("pred_detail")
                .setPredictionCol("pred")
                .setLabelCol("label")
                .setFeatureCols("f0", "f1", "f2", "f3")
                .fit(batchSource)
                .transform(batchSource)
                .print();
        new C45()
                .setPredictionDetailCol("pred_detail")
                .setPredictionCol("pred")
                .setLabelCol("label")
                .setFeatureCols("f0", "f1", "f2", "f3")
                .fit(batchSource)
                .transform(streamSource)
                .print();
        StreamOperator.execute();
    }
}
