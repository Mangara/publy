/*
 * Copyright 2013-2015 Sander Verdonschot <sander.verdonschot at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package publy.data;

import java.util.ArrayList;
import publy.data.bibitem.BibItem;

/**
 *
 *
 */
public class ExampleBibItems extends ArrayList<BibItem> {

    public ExampleBibItems() {
        super(32);
        BibItem item;

        item = new BibItem("inproceedings",
                "bose2014flipping");
        item.put("title", "Flipping Edge-Labelled Triangulations");
        item.put("author", "Bose, Prosenjit and Lubiw, Anna and Pathak, Vinayak and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 25th ACM-SIAM Symposium on Discrete Algorithms (SODA14)");
        item.put("year", "2014");
        item.put("abstract", "The problem of computing the minimum number of flips to transform one triangulation of a convex polygon to another is not known to be in P or NP-complete. A flip sequence determines a one-to-one correspondence between the edges of the two triangulations. As a step towards understanding the source of difficulty, we investigate the problem when this edge correspondence is given, i.e., we want the flip distance between two edge labelled triangulations of a convex polygon. We give tight worst case bounds of $\\Theta(n \\log n)$ on the flip distance between edge labelled triangulations of a convex polygon, and edge-labelled combinatorial triangulations, in contrast to the $\\Theta(n)$ bounds for the unlabelled case. Our method is to reduce to sorting with restricted operations similar to the length-weighted reversals relevant in comparative genomics.  Our bounds imply a lower bound on a very general model of sorting that subsumes a previously known lower bound. We give an $O(\\log n)$-factor approximation algorithm for computing the flip distance between edge labelled triangulations of a convex polygon. We also consider simultaneous flips on edge-labelled triangulations. We prove an $O(\\log^2 n)$ upper bound and an $\\Omega(\\log n)$ lower bound on the worst case number of simultaneous flips, in contrast with the tight bound of $\\Theta(\\log n)$ for the unlabelled case proved in SODA '06.");
        item.put("file", "publications/papers/2014/Bose, Lubiw, Pathak, Verdonschot - Flipping Edge-Labelled Triangulations.pdf");
        item.put("pubstate", "submitted");
        add(item);

        item = new BibItem("inproceedings",
                "barba2014new");
        item.put("title", "New and Improved Spanning Ratios for {Y}ao Graphs");
        item.put("author", "Barba, Luis and Bose, Prosenjit and Damian, Mirela and Fagerberg, Rolf and O'Rourke, Joseph and van Renssen, Andr\\'e and Taslakian, Perouz and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 25th ACM-SIAM Symposium on Discrete Algorithms (SODA14)");
        item.put("year", "2014");
        item.put("abstract", "For a set of points in the plane and a fixed integer $k > 0$, the Yao graph $Y_k$ partitions the space around each point into $k$ equiangular cones, and connects each point to a nearest neighbor in each cone. With the exception of $Y_5$, it is known for all Yao graphs whether or not they are geometric spanners. In this paper we resolve this gap and show that $Y_5$ is a $t$-spanner with spanning ratio $t$ less than 10.9. We also improve the known spanning ratio of all the Yao graphs for odd $k > 5$. Finally, we revisit the $Y_6$ graph, which plays a particularly important role as the transition between the graphs ($k > 6$) for which simple inductive proofs are known, and the graphs ($k \\le 6$) whose best spanning ratios are established by complex arguments. Here we reduce the known spanning ratio of $Y_6$ from $17.6$ to $5.8$.");
        item.put("file", "publications/papers/2014/Barba, Bose, Damian, Fagerberg, ORourke, van Renssen, Taslakian, Verdonschot - New and Improved Spanning Ratios on Yao Graphs.pdf");
        item.put("arxiv", "1307.5829");
        item.put("pubstate", "submitted");
        add(item);

        item = new BibItem("inproceedings",
                "morin2013average");
        item.put("title", "On the Average Number of Edges in Theta Graphs");
        item.put("author", "Morin, Pat and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 11th Meeting on Analytic Algorithmics and Combinatorics (ANALCO14)");
        item.put("year", "2014");
        item.put("abstract", "Theta graphs are important geometric graphs that have many applications, including wireless networking, motion planning, real-time animation, and minimum-spanning tree construction. We give closed form expressions for the average degree of theta graphs of a homogeneous Poisson point process over the plane. We then show that essentially the same bounds—with vanishing error terms—hold for theta graphs of finite sets of points that are uniformly distributed in a square. Finally, we show that the number of edges in a theta graph of points uniformly distributed in a square is concentrated around its expected value.");
        item.put("file", "publications/papers/2014/Morin, Verdonschot - On the Average Number of Edges in Theta Graphs.pdf");
        item.put("arxiv", "1304.3402");
        item.put("pubstate", "submitted");
        add(item);

        item = new BibItem("inproceedings",
                "barba2013inverse");
        item.put("title", "The Inverse Barycenter Problem");
        item.put("author", "Barba, Luis and De Carufel, Jean-Lou and Fleischer, Rudolf and Kawamura, Akitoshi and Korman, Matias and Okamoto, Yoshio and Tang, Yuan and Tokuyama, Takeshi and Verdonschot, Sander and Wang, Tianhao");
        item.put("booktitle", "Proceedings of the 24th International Symposium on Algorithms and Computation (ISAAC 2013)");
        item.put("year", "2013");
        item.put("abstract", "We study the inverse barycenter problem where we want to find locations for given weights on the boundary of a given region in $\\mathbb{R}^2$ realizing a given barycenter point. We show that there is always a solution if the weights are balanced, i.e., no weight is larger than half of the total weight, and that we can compute the placements efficiently for simple polygons. We also study the three-dimensional version of the problem.");
        item.put("file", "publications/papers/2013/Barba, De Carufel, Fleischer, Kawamura, Korman, Okamoto, Tang, Tokuyama, Verdonschot, Wang - The Inverse Barycenter Problem.pdf");
        item.put("pubstate", "submitted");
        add(item);

        item = new BibItem("inproceedings",
                "aichholzer2013theta3");
        item.put("title", "Theta-3 is connected");
        item.put("author", "Aichholzer, Oswin and Bae, Sang Won and Barba, Luis and Bose, Prosenjit and Korman, Matias and van Renssen, Andr\\'e and Taslakian, Perouz and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 25th Canadian Conference on Computational Geometry (CCCG 2013)");
        item.put("pages", "205--210");
        item.put("year", "2013");
        item.put("abstract", "In this paper, we show that the $\\theta$-graph with three cones is connected. We also provide an alternative proof of the connectivity of the Yao-graph with three cones.");
        item.put("file", "publications/papers/2013/Aichholzer, Bae, Barba, Bose, Korman, van Renssen, Taslakian, Verdonschot - Theta-3 is connected.pdf");
        item.put("link", "Slides (pdf)|publications/slides/2013/Theta3.pdf");
        item.put("presented", "yes");
        add(item);

        item = new BibItem("inproceedings",
                "bose2013spanning");
        item.put("title", "On the Spanning Ratio of Theta-Graphs");
        item.put("author", "Bose, Prosenjit and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 13th Algorithms and Data Structures Symposium (WADS 2013)");
        item.put("year", "2013");
        item.put("abstract", "We present improved upper bounds on the spanning ratio of a large family of $\\theta$-graphs. A $\\theta$-graph partitions the plane around each vertex into $m$ disjoint cones, each having aperture $\\theta = 2 \\pi/m$. We show that for any integer $k \\geq 1$, $\\theta$-graphs with $4k + 4$ cones have spanning ratio at most $1 + 2 \\sin(\\theta/2) / (\\cos(\\theta/2) - \\sin(\\theta/2))$. We also show that $\\theta$-graphs with $4k + 3$ and $4k + 5$ cones have spanning ratio at most $\\cos (\\theta/4) / (\\cos (\\theta/2) - \\sin (3\\theta/4))$. This is a significant improvement on all families of $\\theta$-graphs for which exact bounds are not known. For example, the spanning ratio of the $\\theta$-graph with 7 cones is decreased from at most 7.5625 to at most 3.5132. We also improve the upper bounds on the competitiveness of the $\\theta$-routing algorithm for these graphs to $1 + 2 \\sin(\\theta/2) / (\\cos(\\theta/2) - \\sin(\\theta/2))$ on $\\theta$-graphs with $4k + 4$ cones and to $1 + 2 \\sin(\\theta/2) \\cdot \\cos (\\theta/4) / (\\cos (\\theta/2) - \\sin (3\\theta/4))$ on $\\theta$-graphs with $4k + 3$ and $4k + 5$ cones. For example, the routing ratio of the $\\theta$-graph with 7 cones is decreased from at most 7.5625 to at most 4.0490.");
        item.put("file", "publications/papers/2013/Bose, van Renssen, Verdonschot - On the spanning ratio of theta-graphs.pdf");
        add(item);

        item = new BibItem("inproceedings",
                "barba2013stretch");
        item.put("title", "On the stretch factor of the Theta-4 graph");
        item.put("author", "Barba, Luis and Bose, Prosenjit and De Carufel, Jean-Lou and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 13th Algorithms and Data Structures Symposium (WADS 2013)");
        item.put("year", "2013");
        item.put("abstract", "In this paper we show that the $\\theta$-graph with 4 cones has constant stretch factor, i.e., there is a path between any pair of vertices in this graph whose length is at most a constant times the Euclidean distance between that pair of vertices. This is the last $\\theta$-graph for which it was not known whether its stretch factor was bounded.");
        item.put("file", "publications/papers/2013/Barba, Bose, De Carufel, van Renssen, Verdonschot - On the stretch factor of the Theta-4 graph.pdf");
        item.put("arxiv", "1303.5473");
        add(item);

        item = new BibItem("inproceedings",
                "bose2013theta5");
        item.put("title", "The {$\\theta_5$}-graph is a spanner");
        item.put("author", "Bose, Prosenjit and Morin, Pat and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 39th International Workshop on Graph-Theoretic Concepts in Computer Science (WG 2013)");
        item.put("year", "2013");
        item.put("abstract", "We show that the $\\theta$-graph with 5 cones is a geometric spanner with spanning ratio at most $\\sqrt{50 + 22 \\sqrt{5}} \\approx 9.960$. This is the first constant upper bound on the spanning ratio of this graph. The upper bound uses a constructive argument, giving a, possibly non-planar, spanning path between any two vertices. We also give a lower bound on the spanning ratio of $\\frac{1}{2}(11\\sqrt{5} -17) \\approx 3.798$.");
        item.put("file", "publications/papers/2013/Bose, Morin, van Renssen, Verdonschot - The theta_5-graph is a spanner.pdf");
        item.put("arxiv", "1212.0570");
        item.put("link", "Slides (pdf)|publications/slides/2013/Theta5.pdf");
        item.put("presented", "yes");
        add(item);

        item = new BibItem("inproceedings",
                "bose2012competitive2");
        item.put("title", "Competitive Routing on a Bounded-Degree Plane Spanner");
        item.put("author", "Bose, Prosenjit and Fagerberg, Rolf and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 24th Canadian Conference on Computational Geometry (CCCG 2012)");
        item.put("pages", "299--304");
        item.put("year", "2012");
        item.put("abstract", "We show that it is possible to route locally and competitively on two bounded-degree plane 6-spanners, one with maximum degree 12 and the other with maximum degree 9. Both spanners are subgraphs of the empty equilateral triangle Delaunay triangulation. First, in a weak routing model where the only information stored at each vertex is its neighbourhood, we show how to find a path between any two vertices of a 6-spanner of maximum degree 12, such that the path has length at most $95/\\sqrt{3}$ times the straight-line distance between the vertices. In a slightly stronger model, where in addition to the neighbourhood of each vertex, we store $O(1)$ additional information, we show how to find a path that has length at most $15/\\sqrt{3}$ times the Euclidean distance both in a 6-spanner of maximum degree 12 and a 6-spanner of maximum degree 9.");
        item.put("file", "publications/papers/2012/Bose, Fagerberg, van Renssen, Verdonschot - Competitive Routing on a Bounded-Degree Spanner (CCCG).pdf");
        item.put("link", "Slides (pdf)|publications/slides/2012/BoundedDegreeRoutingCCCG.pdf");
        item.put("presented", "yes");
        add(item);

        item = new BibItem("inproceedings",
                "bose2012optimal");
        item.put("title", "Optimal Bounds on Theta-Graphs: More is not Always Better");
        item.put("author", "Bose, Prosenjit and De Carufel, Jean-Lou and Morin, Pat and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 24th Canadian Conference on Computational Geometry (CCCG 2012)");
        item.put("pages", "305--310");
        item.put("year", "2012");
        item.put("abstract", "We present improved upper and lower bounds for a large family of $\\theta$-graphs. We show that $\\theta$-graphs with $4k + 2$ cones ($k \\geq 1$ and integer) have a spanning ratio of $1 + 2 \\sin(\\theta/2)$, where $\\theta$ is $2 \\pi / (4k + 2)$, and this spanning ratio is tight. We also show that $\\theta$-graphs with $4k + 4$ cones have spanning ratio at least $1 + 2 \\tan(\\theta/2) + 4 \\tan^2(\\theta/2)$. This is somewhat surprising since, for equal values of $k$, the spanning ratio of $\\theta$-graphs with $4k + 4$ cones is greater than that of $\\theta$-graphs with $4k + 2$ cones, showing that increasing the number of cones can make the spanning ratio worse.");
        item.put("file", "publications/papers/2012/Bose, Morin, van Renssen, Verdonschot - Optimal Bounds on Theta-Graphs More is not Always Better (CCCG).pdf");
        add(item);

        item = new BibItem("inproceedings",
                "buchin2012evolution");
        item.put("title", "Evolution Strategies for Optimizing Rectangular Cartograms");
        item.put("author", "Buchin, Kevin and Speckmann, Bettina and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 7th International Conference on Geographic Information Science (GIScience 2012)");
        item.put("volume", "7478");
        item.put("series", "Lecture Notes in Computer Science");
        item.put("pages", "29--42");
        item.put("year", "2012");
        item.put("abstract", "A rectangular cartogram is a type of map where every region is a rectangle. The size of the rectangles is chosen such that their areas represent a geographic variable such as population or GDP. In recent years several algorithms for the automated construction of rectangular cartograms have been proposed, some of which are based on rectangular duals of the dual graph of the input map. In this paper we present a new approach to efficiently search within the exponentially large space of all possible rectangular duals. We employ  evolution strategies that find rectangular duals which can be used for rectangular cartograms with correct adjacencies and (close to) zero cartographic error. This is a considerable improvement upon previous methods that have to either relax adjacency requirements or deal with larger errors. We present extensive experimental results for a large variety of data sets.");
        item.put("file", "publications/papers/2012/Buchin, Speckmann, Verdonschot - Evolution Strategies for Optimizing Rectangular Cartograms (GIScience 2012).pdf");
        item.put("doi", "10.1007/978-3-642-33024-7_3");
        item.put("link", "Slides (pdf)|publications/slides/2012/EvolutionStrategiesGIScience.pdf");
        item.put("presented", "yes");
        add(item);

        item = new BibItem("article",
                "buchin2012number");
        item.put("title", "On the Number of Regular Edge Labelings");
        item.put("author", "Buchin, Kevin and Speckmann, Bettina and Verdonschot, Sander");
        item.put("journal", "Discrete Mathematics & Theoretical Computer Science");
        item.put("year", "2012");
        item.put("abstract", "We prove that any irreducible triangulation on $n$ vertices has $O(4.6807^n)$ regular edge labelings and that there are irreducible triangulations on $n$ vertices with $\\Omega(3.0426^n)$ regular edge labelings.");
        item.put("file", "publications/papers/2012/Buchin, Speckmann, Verdonschot - On the Number of Regular Edge Labelings (DMTCS).pdf");
        item.put("link2", "Conference version|#buchin2011optimizing");
        item.put("pubstate", "submitted");
        add(item);

        item = new BibItem("talk",
                "dec2011tue");
        item.put("title", "Making triangulations 4-connected using flips");
        item.put("year", "2011");
        item.put("month", "December");
        item.put("address", "Eindhoven University of Technology");
        item.put("abstract", "An edge flip is an operation that transforms one triangulation into another by replacing the diagonal of the quadrilateral formed by two adjacent triangles with the other possible diagonal. One of the most natural questions to ask, is whether this allows us to transform any given triangulation into any other (with the same number of vertices). This question was answered affirmatively by Wagner, when he introduced the flip operation in 1936. The next logical question then is, how many flips does this take? Careful analysis of Wagner's proof shows that a number of flips quadratic in the number of vertices certainly suffices. However, more recently, Komuro showed that a linear number of flips suffices as well and Mori et al. improved this bound further to $6n - 30$ flips. Their algorithm consists of two steps; it first makes the given triangulation 4-connected and then transforms the result into a fixed canonical triangulation. We give a tight bound of $(3n - 7)/5$ flips on the first step and improve the second step to match the existing lower bound of $2n - 15$ flips, resulting in a new upper bound of $5.2n - 30.8$ flips.");
        item.put("link", "Slides (pdf)|publications/slides/2011/FlipsPresentationTUe.pdf");
        add(item);

        item = new BibItem("article",
                "bose2012making");
        item.put("title", "Making triangulations 4-connected using flips");
        item.put("author", "Bose, Prosenjit and Jansens, Dana and van Renssen, Andr\\'e and Saumell, Maria and Verdonschot, Sander");
        item.put("journal", "Computational Geometry: Theory and Applications special issue for CCCG 2011");
        item.put("year", "2012");
        item.put("abstract", "We show that any combinatorial triangulation on $n$ vertices can be transformed into a 4-connected one using at most $\\lfloor(3n - 9)/5\\rfloor$ edge flips. We also give an example of an infinite family of triangulations that requires this many flips to be made 4-connected, showing that our bound is tight. In addition, for $n \\geq 19$, we improve the upper bound on the number of flips required to transform any 4-connected triangulation into the canonical triangulation (the triangulation with two dominant vertices), matching the known lower bound of $2n - 15$. Our results imply a new upper bound on the diameter of the flip graph of $5.2 n - 33.6$, improving on the previous best known bound of $6n - 30$.");
        item.put("file", "publications/papers/2012/Bose, Jansens, van Renssen, Saumell, Verdonschot - Making triangulations 4-connected using flips (CGTA).pdf");
        item.put("arxiv", "1110.6473");
        item.put("doi", "10.1016/j.comgeo.2012.10.012");
        item.put("link2", "Conference version|#bose2011making");
        add(item);

        item = new BibItem("inproceedings",
                "bose2012plane");
        item.put("title", "On Plane Constrained Bounded-Degree Spanners");
        item.put("author", "Bose, Prosenjit and Fagerberg, Rolf and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 10th Latin American Symposium on Theoretical Informatics (LATIN 2012)");
        item.put("volume", "7256");
        item.put("series", "Lecture Notes in Computer Science");
        item.put("pages", "85--96");
        item.put("year", "2012");
        item.put("abstract", "Let $P$ be a set of points in the plane and $S$ a set of non-crossing line segments with endpoints in $P$. The visibility graph of $P$ with respect to $S$, denoted $Vis(P,S)$, has vertex set $P$ and an edge for each pair of vertices $u,v$ in $P$ for which no line segment of $S$ properly intersects $uv$. We show that the constrained half-$\\theta_6$-graph (which is identical to the constrained Delaunay graph whose empty visible region is an equilateral triangle) is a plane 2-spanner of $Vis(P,S)$. We then show how to construct a plane 6-spanner of $Vis(P,S)$ with maximum degree $6+c$, where $c$ is the maximum number of segments adjacent to a vertex.");
        item.put("file", "publications/papers/2012/Bose, Fagerberg, van Renssen, Verdonschot - On Plane Constrained Bounded-Degree Spanners (LATIN 2012).pdf");
        item.put("doi", "10.1007/978-3-642-29344-3_8");
        item.put("link", "Slides (pdf)|publications/slides/2012/Verdonschot - ConstrainedBoundedDegreeSpanners.pdf");
        item.put("presented", "yes");
        add(item);

        item = new BibItem("incollection",
                "bose2012history");
        item.put("title", "A History of Flips in Combinatorial Triangulations");
        item.put("author", "Bose, Prosenjit and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the XIV Spanish Meeting on Computational Geometry (EGC 2011)");
        item.put("volume", "7579");
        item.put("series", "Lecture Notes in Computer Science");
        item.put("pages", "29--44");
        item.put("editor", "M\\'arquez, Alberto and Ramos, Pedro and Urrutia, Jorge");
        item.put("publisher", "Springer Berlin Heidelberg");
        item.put("year", "2012");
        item.put("abstract", "Given two combinatorial triangulations, how many edge flips are necessary and sufficient to convert one into the other? This question has occupied researchers for over 75 years. We provide a comprehensive survey, including full proofs, of the various attempts to answer it.");
        item.put("file", "publications/papers/2012/Bose, Verdonschot - A History of Flips in Combinatorial Triangulations.pdf");
        item.put("arxiv", "1206.0303");
        item.put("doi", "10.1007/978-3-642-34191-5_3");
        add(item);

        item = new BibItem("inproceedings",
                "bose2012competitive");
        item.put("title", "Competitive Routing in the Half-{$\\theta_6$}-Graph");
        item.put("author", "Bose, Prosenjit and Fagerberg, Rolf and van Renssen, Andr\\'e and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 23rd ACM-SIAM Symposium on Discrete Algorithms (SODA 2012)");
        item.put("pages", "1319--1328");
        item.put("year", "2012");
        item.put("abstract", "We present a deterministic local routing scheme that is guaranteed to find a path between any pair of vertices in a half-$\\theta_6$-graph whose length is at most $5/\\sqrt{3}$ times the Euclidean distance between the pair of vertices. The half-$\\theta_6$-graph is identical to the Delaunay triangulation where the empty region is an equilateral triangle. Moreover, we show that no local routing scheme can achieve a better competitive spanning ratio thereby implying that our routing scheme is optimal. This is somewhat surprising because the spanning ratio of the half-$\\theta_6$-graph is 2. Since every triangulation can be embedded in the plane as a half-$\\theta_6$-graph using $O(\\log n)$ bits per vertex coordinate via Schnyder's embedding scheme (SODA 1990), our result provides a competitive local routing scheme for every such embedded triangulation.");
        item.put("file", "publications/papers/2012/Bose, Fagerberg, van Renssen, Verdonschot - Competitive Routing on the Half-theta_6-Graph (SODA 2012).pdf");
        item.put("link3", "ACM|http://dl.acm.org/citation.cfm?id=2095116.2095220");
        add(item);

        item = new BibItem("inproceedings",
                "deberg2011rectilinear");
        item.put("title", "On rectilinear partitions with minimum stabbing number");
        item.put("author", "de Berg, Mark and Khosravi, Amirali and Verdonschot, Sander and van der Weele, Vincent");
        item.put("booktitle", "Proceedings of the 12th Algorithms and Data Structures Symposium (WADS 2011)");
        item.put("pages", "302--313");
        item.put("year", "2011");
        item.put("abstract", "Let $S$ be a set of $n$ points in $\\mathbb{R}^d$, and let $r$ be a parameter with $1 \\leq r \\leq n$. A rectilinear $r$-partition for $S$ is a collection $\\Psi(S) := \\{(S_1, b_1), \\dots , (S_t, b_t)\\}$, such that the sets $S_i$ form a partition of $S$, each $b_i$ is the bounding box of $S_i$, and $n/2r \\leq |S_i| \\leq 2n/r$ for all $1 \\leq i \\leq t$. The (rectilinear) stabbing number of $\\Psi(S)$ is the maximum number of bounding boxes in $\\Psi(S)$ that are intersected by an axis-parallel hyperplane $h$. We study the problem of finding an optimal rectilinear $r$-partition - a rectilinear partition with minimum stabbing number - for a given set $S$. We obtain the following results.<br> - Computing an optimal partition is NP-hard already in $\\mathbb{R}^2$.<br> - There are point sets such that any partition with disjoint bounding boxes has stabbing number $\\Omega(r^{1-1/d})$, while the optimal partition has stabbing number 2.<br> - An exact algorithm to compute optimal partitions, running in polynomial time if $r$ is a constant, and a faster 2-approximation algorithm.<br> - An experimental investigation of various heuristics for computing rectilinear $r$-partitions in $\\mathbb{R}^2$.");
        item.put("file", "publications/papers/2011/de Berg, Khosravi, Verdonschot, van der Weele - On Rectilinear Partitions with Minimum Stabbing Number (WADS 2011).pdf");
        item.put("doi", "10.1007/978-3-642-22300-6_26");
        add(item);

        item = new BibItem("inproceedings",
                "bose2011making");
        item.put("title", "Making triangulations 4-connected using flips");
        item.put("author", "Bose, Prosenjit and Jansens, Dana and van Renssen, Andr\\'e and Saumell, Maria and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 23rd Canadian Conference on Computational Geometry (CCCG 2011)");
        item.put("pages", "241--247");
        item.put("year", "2011");
        item.put("abstract", "We show that any triangulation on $n$ vertices can be transformed into a 4-connected one using at most $\\lfloor(3n - 6)/5\\rfloor$ edge flips. We also give an example of a triangulation that requires $\\lceil(3n - 10)/5\\rceil$ flips to be made 4-connected, showing that our bound is tight. Our result implies a new upper bound on the diameter of the flip graph of $5.2 n - 24.4$, improving on the bound of $6n -30$ by Mori et al.");
        item.put("file", "publications/papers/2011/Bose, Jansens, van Renssen, Saumell, Verdonschot - Making triangulations 4-connected using flips (CCCG 2011).pdf");
        item.put("link", "Slides (pdf)|publications/slides/2011/FlipsPresentationCCCG.pdf");
        item.put("presented", "yes");
        item.put("link2", "Journal version|#bose2012making");
        add(item);

        item = new BibItem("inproceedings",
                "buchin2011optimizing");
        item.put("title", "Optimizing regular edge labelings");
        item.put("author", "Buchin, Kevin and Speckmann, Bettina and Verdonschot, Sander");
        item.put("booktitle", "Proceedings of the 18th International Symposium on Graph drawing (GD 2010)");
        item.put("series", "Lecture Notes in Computer Science");
        item.put("volume", "6502");
        item.put("pages", "117--128");
        item.put("year", "2011");
        item.put("publisher", "Springer-Verlag");
        item.put("address", "Heidelberg");
        item.put("abstract", "A regular edge labeling (REL) of an irreducible triangulation $G$ uniquely defines a rectangular dual of $G$. Rectangular duals find applications in various areas: as floor plans of electronic chips, in architectural designs, as rectangular cartograms, or as treemaps. An irreducible triangulation can have many RELs and hence many rectangular duals. Depending on the specific application different duals might be desirable. In this paper we consider optimization problems on RELs and show how to find optimal or near-optimal RELs for various quality criteria. Along the way we give upper and lower bounds on the number of RELs.");
        item.put("file", "publications/papers/2011/Buchin, Speckmann, Verdonschot - Optimizing Regular Edge Labelings (GD 2010).pdf");
        item.put("doi", "10.1007/978-3-642-18469-7_11");
        item.put("link2", "Journal version|#buchin2012number");
        add(item);

        item = new BibItem("mastersthesis",
                "verdonschot2010optimizing");
        item.put("author", "Verdonschot, Sander");
        item.put("title", "Optimizing Regular Edge Labelings");
        item.put("school", "Eindhoven University of Technology");
        item.put("year", "2010");
        item.put("abstract", "A regular edge labeling of an irreducible triangulation $G$ uniquely defines a rectangular dual of $G$. Rectangular duals find applications in various areas: as floor plans of electronic chips, in architectural designs, as rectangular cartograms, or as treemaps. An irreducible triangulation can have many regular edge labelings and hence many rectangular duals. Depending on the specific application different duals might be desirable. In this thesis we consider optimization problems on regular edge labelings and show how to find optimal or near-optimal ones for various quality criteria. We evaluate our optimization methods by applying them to generate high quality rectangular cartograms. Furthermore, we show how to efficiently enumerate the regular edge labelings of an irreducible triangulation. Since the running time of the enumeration algorithm depends on the number of regular edge labelings, we also consider the maximal number of regular edge labelings an irreducible triangulation can have. We show that every irreducible triangulation with $n$ vertices has less than $O(4.6807^n)$ regular edge labelings and that there are irreducible triangulations with $\\Omega(3.0426^n)$ regular edge labelings.");
        item.put("file", "publications/papers/2010/Verdonschot - Optimizing Regular Edge Labelings (Master Thesis).pdf");
        add(item);
    }
}
